import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greeting()
    
    
    @ObservedObject var viewModel :  CatInfoViewModel
    
    init() {
        self.viewModel =  CatInfoViewModel(
            getRandomCatInfo: GetRandomCatInfo(
                catInfoRepository: CatInfoRepositoryImpl(
                    catInfoApiService: CatInfoApiServiceImpl(
                        httpClient: KtorClientFactory().build(),
                        baseUrl: "https://catfact.ninja"),
                    networkToDomainCatInfoMapper: NetworkToDomainCatInfoMapper())),
            failureToErrorMessageMapper: FailureToErrorMessageMapper()
        )
    }
    
    
    var body: some View {
        
        VStack(alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/, spacing: /*@START_MENU_TOKEN@*/nil/*@END_MENU_TOKEN@*/, content: {
            if viewModel.state.isLoading {
                ProgressView().progressViewStyle(CircularProgressViewStyle())
            }
            if viewModel.state.catInfo != nil {
                Text(viewModel.state.catInfo ?? "")
                    .padding(.horizontal, 16)
                Button(
                    action: { viewModel.onTriggerEvent(stateEvent: CatInfoEvent.GetCatInfo())},
                    label: {Text("Get random quote")})
                    .padding(.top, 16)
            }
        })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
