class CatInfoViewModel: ObservableObject {

    @Publised var catInfoViewState = CatInfoViewState()

    private let getRandomCatInfo: GetRandomCatInfo

    init(getRandomCatInfo: GetRandomCatInfo){
        self.getRandomCatInfo = getRandomCatInfo
    }
}