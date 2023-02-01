//
//  regionViewController.swift
//  TP2-GROUPE-Mamouni-Benayad
//
//  Created by Yahya MAMOUNI on 01/02/2023.
//

import Foundation
import UIKit



class RegionViewController: UIViewController, UITableViewDataSource {
    var region : Region?
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell()
        cell.textLabel?.text = (data[indexPath.item]).nom
        return cell
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return data.count
    }
    
    private func tableView(_ tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
        print("selected cell")
    }

    @IBOutlet var tableView: UITableView!
    let data = Regions.all
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        view.backgroundColor = .red

    }

}

