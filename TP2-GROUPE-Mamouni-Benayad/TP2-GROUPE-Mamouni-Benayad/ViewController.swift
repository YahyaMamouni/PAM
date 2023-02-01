//
//  ViewController.swift
//  TP2-GROUPE-Mamouni-Benayad
//
//  Created by Yahya MAMOUNI on 01/02/2023.
//

import UIKit

class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
  

    @IBOutlet var tableView: UITableView!
    let data = Regions.all
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        view.backgroundColor = .red
        tableView.dataSource = self
        tableView.delegate = self
        
        //
        
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell()
        cell.textLabel?.text = (data[indexPath.item]).nom
        return cell
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return data.count
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print("selected cell")
        
        let newWindow = RegionViewController()
        newWindow.region = (data[indexPath.item])
        navigationController?.pushViewController(newWindow, animated: true)
        
    }
/*    func tableView(_ tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
        print("selected cell")
        
        let newWindow = regionViewController()
        newWindow.region = (data[indexPath.item])
        navigationController?.pushViewController(newWindow, animated: true)
        
    }*/
    
       

    

}

