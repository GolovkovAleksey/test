public enum StudyProfile {
        TEACHER("Учитель"), ENGINEER("Инженер"), MEDICINE("Медицина");
        private String transletion;
        StudyProfile(String transletion){
                this.transletion = transletion;
        }
        public String getTransletion(){
                return  transletion;
        }

        public String toString(){
              return transletion;
        }
}
