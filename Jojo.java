import java.util.*;

class Candidate {
    private String candName;
    private String candDistrict;
    private String party;
    private ArrayList<String> votes;
    
    public String getCandName() {
        return candName;
    }

    public String getCandDistrict() {
        return candDistrict;
    }

    public String getParty() {
        return party;
    }

    public int getVotes() {
        return votes.size();
    }

    public Candidate(String candName, String candDistrict, String party) {
        this.candName = candName;
        this.candDistrict = candDistrict;
        this.party = party;
        this.votes = new ArrayList<>();
    }
    public void voteCandidate(String adhar) {
        if(this.votes.contains(adhar)) {
            System.out.println("CANNOT VOTE MULTIPLE TIMES");
        } else {
            this.votes.add(adhar);
            System.out.println("SUCCESSFULLY VOTED ");
        }
    }
}

class Candidates {
    public static Scanner s = new Scanner(System.in);
    private static ArrayList<Candidate> candList = new ArrayList<>();

    public void addCandidate() {

        System.out.println("PROVIDE FULLNAME");
        String fullName = s.nextLine();
        System.out.println("PROVIDE DISTRICT NAME ");
        String district = s.nextLine();
        System.out.println("PROVIDE PARTY NAME");
        String party = s.nextLine();
        Candidate c = new Candidate(fullName,district,party);
        this.candList.add(c);
    }

    public void getCandidates() {
        int num = 1;
        System.out.println("CANDIDATES");
        for(Candidate v : this.candList) {
            System.out.println("ID : "+num++);
            System.out.println("CANDIDATE NAME : "+v.getCandName());
            System.out.println("DISTRICT : "+v.getCandDistrict());
            System.out.println("PARTY : "+v.getParty());
            System.out.println("TOTAL VOTES : "+v.getVotes());
            System.out.println("___________________");
        }
    }

    public void deleteCandidate() {
        
        int num = 1;
        System.out.println("CANDIDATES");
        for(Candidate v : this.candList) {
            System.out.println("ID : "+num++);
            System.out.println("CANDIDATE NAME : "+v.getCandName());
            System.out.println("PARTY : "+v.getParty());
            System.out.println("___________________");
        }
        System.out.println("CHOOSE CANDIDATE ID TO DELETE : ");
        int id = s.nextInt();
        id--;
        candList.remove(id);
        System.out.println("SUCCESSFULLY REMOVED ");
    }

    public void vote(String adhar) {
        
        int num = 1;
        System.out.println("CANDIDATES");
        for(Candidate v : this.candList) {
            System.out.println("ID : "+num++);
            System.out.println("CANDIDATE NAME : "+v.getCandName());
            System.out.println("PARTY : "+v.getParty());
            System.out.println("___________________");
        }
        System.out.println("CHOOSE CANDIDATE ID TO VOTE : ");
        int id = s.nextInt();
        id--;
        candList.get(id).voteCandidate(adhar);
        
    }
}

class Voter {
    private String adharNumber;
    private String fullName;
    private String district;

    public String getAdharNumber() {
        return adharNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDistrict() {
        return district;
    }


    public Voter(String adharNumber, String fullName, String district) {
        this.adharNumber = adharNumber;
        this.fullName = fullName;
        this.district = district;
    }
}

class Voters {

    public static Scanner s = new Scanner(System.in);
    private static ArrayList<Voter> jojo = new ArrayList<>();

    public void addVoter() {
        System.out.println("PROVIDE ADHAAR NUMBER");
        String adhar = s.nextLine();
        for(Voter v : this.jojo) {
            if(v.getAdharNumber().compareTo(adhar)==0) {
                System.out.println("USER HAS ALREADY REGISTERED");
                return;
            }
        }
        System.out.println("PROVIDE FULLNAME");
        String fullName = s.nextLine();
        System.out.println("PROVIDE DISTRICT");
        String district = s.nextLine();
        Voter v = new Voter(adhar,fullName,district);
        this.jojo.add(v);
    }

    public void getVoters() {
        int num = 1;
        System.out.println("VOTERS");
        for(Voter v : this.jojo) {
            System.out.println("ID : "+num++);
            System.out.println("ADHAAR NUMBER : "+v.getAdharNumber());
            System.out.println("VOTER NAME : "+v.getFullName());
            System.out.println("DISTRICT : "+v.getDistrict());
            System.out.println("___________________");
        }
    }

    public Boolean Login(String adhar) {
        for(Voter v : this.jojo) {
            if(v.getAdharNumber().compareTo(adhar) == 0) {
                return true;
            }
        }
        return false;
    }
}



class Jojo {
    public static Scanner s = new Scanner(System.in);
    static Voters v = new Voters();
    static Candidates c = new Candidates();

    public static void mainContent() {
        int opt = 0;
        while(opt!=4) {
            try {
                System.out.println("\n\n___WELCOME TO E-VOTING SYSTEM____");
                System.out.println("1.VOTER LOGIN");
                System.out.println("2.ADMIN LOGIN");
                System.out.println("3.VOTER REGISTER");
                System.out.println("4.EXIT");
                System.out.print("PLEASE PROVIDE AN OPTION : ");
                opt = s.nextInt();
                
                if(opt==2) {
                    System.out.println("PROVIDE ADMIN USERCODE : ");
                    s.nextLine();
                    String userName = s.nextLine();
                    System.out.println("PROVIDE ADMIN PASSCODE : ");
                    String passCode = s.nextLine();
                    if(userName.compareTo("jojo")==0 && passCode.compareTo("jojo")==0) {
                        int spt=0;
                        while(spt!=4) {
                            System.out.println("\n__WELCOME ADMIN!__\n");
                            
                            System.out.println("\t1.ADD COMPETETORS ");
                            System.out.println("\t2.REMOVE COMPETETORS  ");
                            System.out.println("\t3.VIEW VOTES: ");
                            System.out.println("\t4.EXIT: ");
                            System.out.print("\tCHOOSE ANY : ");
                            spt = s.nextInt();
                            if(spt==1) {
                                c.addCandidate();
                            }
                            if(spt==2) {
                                c.deleteCandidate();
                            }
                            if(spt==3) {
                                c.getCandidates();
                            }
                        }
                    } else {
                        System.out.print("\tAUTHORIZATION FAILED ");
                    }
                }


                if(opt == 1) {
                    System.out.println("PROVIDE YOUR ADHAR NUMBER : ");
                    s.nextLine();
                    String adharNumb = s.nextLine();

                    if(v.Login(adharNumb)) {
                        int spt = 0; 
                        while(spt!=2) {
                            System.out.println("\n__LOGIN SUCCESS__\n");
                            System.out.println("\t1.VOTE ");
                            System.out.println("\t2.EXIT: ");
                            System.out.print("\tCHOOSE ANY : ");
                            spt = s.nextInt();
                            if(spt==1) {
                                c.vote(adharNumb);
                            }
                        }
                    } else {
                        System.out.println("CREDENTIALS NOT RECOGNISED BY OUR INTERNAL SYSTEM");
                    }
                }

                if(opt == 3) {
                    v.addVoter();
                }

            } catch (Exception e) {
                System.out.println("PLEASE PROVIDE VALID INPUT!");
                continue;
            }
        }
        System.out.print("THANK YOU FOR USING OUR SERVICE");
    }

    public static void main(String[] args) {
        mainContent();
    }
}

