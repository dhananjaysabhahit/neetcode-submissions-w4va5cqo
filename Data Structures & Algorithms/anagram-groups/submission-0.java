class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] strsSorted = new String[strs.length];
        for(int i=0;i<strs.length;i++){
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            strsSorted[i] = new String(sorted);
        }
        
        List<List<String>> list = new ArrayList();
        Map<String,List<String>> map = new HashMap();
        for(int i=0;i<strs.length;i++){
            if(map.containsKey(strsSorted[i])){
                map.get(strsSorted[i]).add(strs[i]);
            } else {
                List<String> innerList = new ArrayList(List.of(strs[i]));
                map.put(strsSorted[i],innerList);
            }
        }
        for(List<String> val: map.values()){
            list.add(val);
        }
        return list;
    }
}
