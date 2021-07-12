//
//  CatInfoViewModel.swift
//  iOSCatFacts
//
//  Created by Marin Juricev on 12.07.2021..
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

extension String: Error {}

class CatInfoViewModel: ObservableObject {
    
    let getRandomCatInfo: GetRandomCatInfo
    let failureToErrorMessageMapper: FailureToErrorMessageMapper
    
    @Published var state: CatInfoViewState = CatInfoViewState()
    
    init(
        getRandomCatInfo: GetRandomCatInfo,
        failureToErrorMessageMapper: FailureToErrorMessageMapper
    ){
        self.getRandomCatInfo = getRandomCatInfo
        self.failureToErrorMessageMapper = failureToErrorMessageMapper
        
        onTriggerEvent(stateEvent: CatInfoEvent.GetCatInfo())
    }
    
    
    func onTriggerEvent(stateEvent: CatInfoEvent)  {
        switch stateEvent {
        case is CatInfoEvent.GetCatInfo:
            handleGetCatInfo()
        default:
            Swift.print ("Unhandled stateEvent, ignore for this dummy app")
        }
    }
    
    func doNothing(){}
    
    func handleGetCatInfo(){
        let currentState = (self.state.copy() as! CatInfoViewState)
        
        self.state = self.state.doCopy(
            errorMessage: nil,
            catInfo: nil,
            isLoading: true
        )
        
        getRandomCatInfo.execute() { result, error in
            if(result != nil){
                if let catInfos = result as? EitherRight<CatInfo> {
                    self.state = self.state.doCopy(
                        errorMessage: nil ?? currentState.errorMessage,
                        catInfo: catInfos.value?.information ?? currentState.catInfo,
                        isLoading: false
                    )
                }
            }
            if(error != nil){
                self.state = self.state.doCopy(
                    errorMessage: "Error occured" ?? currentState.errorMessage,
                    catInfo: nil ?? currentState.catInfo,
                    isLoading: false
                )
            }
        }
    }
}

