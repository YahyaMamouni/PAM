//
//  AppDelegate.swift
//  TP2-GROUPE-Mamouni-Benayad
//
//  Created by Yahya MAMOUNI on 01/02/2023.
//

import UIKit

@main
class AppDelegate: UIResponder, UIApplicationDelegate {

    let window = UIWindow(frame:UIScreen.main.bounds)

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        let navCtroller = UINavigationController(rootViewController: ViewController())
       window.rootViewController = ViewController()
        
        window.makeKeyAndVisible()
        return true
    }

    

}

