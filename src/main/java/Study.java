public class Study {
    private StudyDraft studyDraft;
    private int memeberCount ;

    public Study(StudyDraft studyDraft, int memeberCount){
        this.studyDraft = studyDraft;
        this.memeberCount = memeberCount;

        if(memeberCount <=0){
            throw new IllegalArgumentException("사람이 적어요");
        }
    }

    public void setStudyDraft(StudyDraft studyDraft) {
        this.studyDraft = studyDraft;
    }

    public void setMemeberCount(int memeberCount) {
        if(memeberCount <=0){
            throw new IllegalArgumentException("사람이 적어요");
        }
        this.memeberCount = memeberCount;
    }

}
