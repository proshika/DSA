class Solution {
private static final int MOD = 1000000007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int arraysize=(n<<1)+10;
        long[] peopleknowsecret=new long[arraysize];
        long[] newpeople=new long[arraysize];
        newpeople[1]=1;
        for(int currday=1;currday<=n;currday++){
          if(newpeople[currday]>0){
            peopleknowsecret[currday]=peopleknowsecret[currday]+newpeople[currday]%MOD;
            peopleknowsecret[currday+forget]=(peopleknowsecret[currday+forget]-newpeople[currday]+MOD)%MOD;
            int startday=currday+delay;
            while(startday<currday+forget){
                newpeople[startday]=(newpeople[startday]+newpeople[currday])%MOD;
                startday++;
            }
          }
        }long totalpeople=0;
        for(int day=1;day<=n;day++){
            totalpeople=(totalpeople+peopleknowsecret[day])%MOD;
        }
           return (int)totalpeople;
    }
}