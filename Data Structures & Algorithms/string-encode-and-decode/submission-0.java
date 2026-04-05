class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append(",");
        }

        sb.append("#");
        
        for(String str: strs){
            sb.append(str);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.length()==0){
            return List.of();
        } 
        int i=0;
        List<Integer> sizes = new ArrayList<>();
        List<String> res = new ArrayList<>();
        while(str.charAt(i)!='#'){
            StringBuilder sb = new StringBuilder();
            while(str.charAt(i)!=','){
                sb.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(sb.toString()));
            i++;
        }
        i++;
        for(int size: sizes){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<size;j++){
                sb.append(str.charAt(i++));
            }
            res.add(sb.toString());
        }
        
        return res;
    }
}
