package _4kyu;

import java.util.*;

public class MostFrequentlyUsedWordsInAText {
    public static List<String> top3(String s) {
        s = s.replaceAll("[\\W&&[^']]"," ");
        s = s.replaceAll("_"," ");
        s = s.replaceAll("\s+"," ");
//        s = s.replaceAll("[\\W&&[^']&&[^ ]]","");
        s = s.replaceAll(" '+ ","");
        s = s.trim();
        if(s.equals("")){
            return (Arrays.asList(new String[]{}));
        }

        s = s.toLowerCase(Locale.ROOT);
        String[] words = s.split(" ");
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
//            String word = words[i].replaceAll("[\\W&&[^']]","");
            String word = words[i];
            if(wordMap.containsKey(word)){
                wordMap.put(word,wordMap.get(word) + 1);
            }else{
                wordMap.put(word,1);
            }
        }
//        System.out.println(wordMap);
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String, Integer>>(wordMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<String> rez = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            rez.add(list.get(i).toString().split("=")[0]);
            if(i == 2){
                break;
            }
        }
        return rez;
    }


    public static void main(String[] args) {
//        System.out.println(top3("a a a  b  c c  d d d d  e e e e e"));
//        System.out.println(top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
//        System.out.println(top3("  //wont won't won't "));
        System.out.println(top3("f'yxH f'yxH f'yxH/f'yxH f'yxH f'yxH f'yxH f'yxH.f'yxH f'yxH f'yxH_f'yxH:f'yxH-f'yxH f'yxH f'yxH?f'yxH.f'yxH/f'yxH"));
//        System.out.println(top3("cbL;rzXq-zOjOp'O.qWxaOr_yeiCFjMw-fjdZT rDBHRDHdh_zOjOp'O,zOjOp'O_jAvOpSWPB rDBHRDHdh/rDBHRDHdh!anyflWRpGm INOXCOme anyflWRpGm DOZv zOjOp'O INOXCOme,INOXCOme?fjdZT qWxaOr:qWxaOr.RvhyAfR'Rw,RvhyAfR'Rw fjdZT:zOjOp'O!fjdZT/fjdZT fjdZT-zOjOp'O,INOXCOme anyflWRpGm qWxaOr zOjOp'O rDBHRDHdh RvhyAfR'Rw-DOZv:qWxaOr qWxaOr/qWxaOr?INOXCOme_yeiCFjMw/fjdZT yeiCFjMw DOZv_RvhyAfR'Rw_zOjOp'O!INOXCOme_fjdZT qWxaOr qWxaOr zOjOp'O;INOXCOme?qWxaOr RvhyAfR'Rw anyflWRpGm zOjOp'O RvhyAfR'Rw INOXCOme DOZv anyflWRpGm?qWxaOr?zOjOp'O fjdZT-INOXCOme-RvhyAfR'Rw:rDBHRDHdh RvhyAfR'Rw-anyflWRpGm_zOjOp'O yeiCFjMw,INOXCOme YiBeRqSN_anyflWRpGm/jAvOpSWPB rDBHRDHdh,zOjOp'O.qWxaOr jAvOpSWPB fjdZT fjdZT rDBHRDHdh!qWxaOr DOZv yeiCFjMw_rzXq RvhyAfR'Rw-INOXCOme yeiCFjMw YiBeRqSN fjdZT INOXCOme qWxaOr,qWxaOr;RvhyAfR'Rw_zOjOp'O-rDBHRDHdh;DOZv RvhyAfR'Rw rDBHRDHdh:qWxaOr jAvOpSWPB DOZv,yeiCFjMw rDBHRDHdh?jAvOpSWPB,fjdZT:zOjOp'O anyflWRpGm qWxaOr cbL?RvhyAfR'Rw;RvhyAfR'Rw DOZv rDBHRDHdh,fjdZT?anyflWRpGm-jAvOpSWPB.rzXq!INOXCOme rDBHRDHdh.YiBeRqSN YiBeRqSN anyflWRpGm;rDBHRDHdh?DOZv/INOXCOme rzXq DOZv-qWxaOr,fjdZT!zOjOp'O/RvhyAfR'Rw?zOjOp'O zOjOp'O rDBHRDHdh;rDBHRDHdh fjdZT yeiCFjMw-DOZv yeiCFjMw.rDBHRDHdh-fjdZT zOjOp'O fjdZT,qWxaOr jAvOpSWPB yeiCFjMw/jAvOpSWPB_DOZv rzXq jAvOpSWPB?zOjOp'O yeiCFjMw!yeiCFjMw/qWxaOr.fjdZT YiBeRqSN.fjdZT RvhyAfR'Rw qWxaOr rDBHRDHdh INOXCOme?rDBHRDHdh INOXCOme RvhyAfR'Rw zOjOp'O?qWxaOr INOXCOme?rzXq fjdZT RvhyAfR'Rw yeiCFjMw jAvOpSWPB RvhyAfR'Rw,yeiCFjMw!anyflWRpGm_rDBHRDHdh.qWxaOr fjdZT jAvOpSWPB!fjdZT?zOjOp'O,rDBHRDHdh INOXCOme/rzXq RvhyAfR'Rw-anyflWRpGm!DOZv yeiCFjMw-zOjOp'O_fjdZT YiBeRqSN.rDBHRDHdh qWxaOr fjdZT:rzXq RvhyAfR'Rw,rDBHRDHdh RvhyAfR'Rw_qWxaOr yeiCFjMw INOXCOme rDBHRDHdh_RvhyAfR'Rw RvhyAfR'Rw anyflWRpGm fjdZT INOXCOme,INOXCOme rDBHRDHdh jAvOpSWPB!qWxaOr anyflWRpGm DOZv DOZv.fjdZT fjdZT jAvOpSWPB"));
        //[fjdzt, qwxaor, rdbhrdhdh]
    }

}
