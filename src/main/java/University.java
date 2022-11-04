public class University {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public String getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(String mainProfile) {
        this.mainProfile = mainProfile;
    }
    String id;
   String fullName;
   String shortName;
   int yearOfFoundation;
   String mainProfile;

    public String toString(){
        return fullName +" "+shortName+" "+yearOfFoundation+" "+ mainProfile+" "+id;
    }
}
