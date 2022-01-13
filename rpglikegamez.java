package com.homejp;

import java.io.*;
import java.util.regex.*;


public class rpglikegamez {
    public static void main(String[] rgpz){
        
        //変数定義
        int sts =0;      //メイン処理のステータスコード。
        int phasestscode =0;      //現在の進行中の場面を示すコード。
        int cngflg = 0;       //キャラクターも基本情報を変更する際に必要な係数。1の場合のみ変更可能。
        
        //使用するクラスをインスタンス化する。
        endsshori endz = new endsshori();      //システム終了処理
        messagezdb msgdb = new messagezdb();
        multithread multishori = new multithread();
        wait wait1 = new wait();
        kaigyo kai1 = new kaigyo();
        
        
    //オープニング処理_start_
        
        //進行コードの判断(オープニング開始条件はコードが"0"の場合のみ。)
        if (phasestscode >0 | phasestscode <0) {
            endz.ends(9);
        } else if (phasestscode == 0) {
        }
        
        //オープニングメッセージ表示。
        messagezaction msgaction = new messagezaction();

        int msgactionsts;
        int opmsgvlme = msgdb.opmsgvolume;
        int endsts =0;
        
        for (int msgcunt = 1; msgcunt <=opmsgvlme ; msgcunt++){
            
//            if (msgcunt == opmsgvlme) {
//                msgcunt =99;
//           }
            msgaction.stepcntset(msgcunt);       //表示するメッセージの順番を示す番号に初期値の"0"を代入する。
            msgactionsts = msgaction.msgact(phasestscode);
            
            if (msgaction.msgsts ==1){
                break;
            } else if (msgactionsts <0 | msgaction.msgsts !=0) {
                sts =1;
                if (msgaction.msgsts <0) {
                    endz.ends(9);
                }
                break;
            }
            
            wait1.waitmain(2500);
            if (wait1.wait ==1){
                endz.ends(9);
            }
        }
    System.out.println(kai1.kaigyou());
    
    phasestscode = 1;      //進行コードを"1"に変更。
    
    //オープニング処理_end_
        
    //名前入力処理_開始_
    
        //変数定義_名前入力_
        
        //使用メソッド定義_
        nyuuryoku nyuuryoku = new nyuuryoku();
        charabase charabase = new charabase();
        
        //進行コードの判断(名前入力処理開始条件はコードが"1"の場合のみ。)
        if (phasestscode >1 | phasestscode <1) {
            endz.ends(9);
        } else if (phasestscode == 1) {
        }
        
    String msgendop = "\"エンターキー\"を入力して下さい。_";
    
    multishori.setPriority(2);
    multishori.start();
    multishori.multith(msgendop,1);
    
    
    //最初のプレイヤー情報作成処理(勇者)
    
    //キャラ情報をインスタンス化して勇者の基本情報を作成する。
    charadatabase yuusha = new charadatabase();       //勇者誕生！！
    String name_yuusha = "";            //勇者の名前表示用変数
    String gender_yuusha = "";            //勇者の性別表示用変数
    
    //名前入力処理メイン_
//    nyuuryoku nyuuryoku = new nyuuryoku();
    String stsans1 = charabase.charamakebase1name_gender(0);
    if (stsans1.equals("error")){
        endz.ends(9);
    } else if (stsans1.equals("OK")) {
        cngflg = charabase.cngflg;
    }
    
    yuusha.cngbasedata(charabase.showsts(0),1,cngflg);
    
    if (yuusha.getbasests()==9){
        System.out.println("キャラクター情報の登録処理を中断しました。");
        endz.ends(9);
    } else if (charabase.showstscd() ==1) {
        System.out.println("入力を複数回間違えた為、ゲームを終了します。最初からやり直して下さい。");
        endz.ends(9);        
    } else {
        cngflg = 0;
    }
    
    String stsans2 = charabase.charamakebase1name_gender(1);
    if (stsans2.equals("error")){
        endz.ends(9);
    } else if (stsans2.equals("OK")) {
        cngflg = charabase.cngflg;
    }
    
    yuusha.cngbasedata(charabase.showsts(1),2,cngflg);
    
    if (yuusha.getbasests()==9){
        System.out.println("キャラクター情報の登録処理を中断しました。");
        endz.ends(9);
    } else if (charabase.showstscd() ==1) {
        System.out.println("入力を複数回間違えた為、ゲームを終了します。最初からやり直して下さい。");
        endz.ends(9);        
    } else {
        cngflg = 0;
    }
        
        name_yuusha = yuusha.getbasedata(1);
        gender_yuusha = yuusha.getbasedata(2);
        
        yuusha.showbasedata();

        //勇者のステータス登録
        charashubase yuushasts= new charashubase(0);

        if (name_yuusha !="" && gender_yuusha != "") {
            cngflg =1;
            yuushasts.nameseibetuputmathod(cngflg,name_yuusha,gender_yuusha);
            cngflg =0;
        }
        yuushasts.showplayersts();

  System.out.println("ゲームの処理を正常に終了しました。");
    }
}
//class playerz{ //キャラ選択
//    public static 
//}
class messagezaction{
    
    //メッセージdbをインスタンス化
    static messagezdb msgdb = new messagezdb();
    static kaigyo kai1 = new kaigyo();
    static wait wait2= new wait();
    static endsshori endz = new endsshori();
    
    //変数定義
    private static int stepcnt;   //メッセージの順番をカウントする変数。
    private static String nowmsg ="";      //現在表示しているメッセージに対応している。
    
    public static int msgsts =0;     //メッセージクラスのステータスコード。
    
    //変数代入
    
    public static void stepcntset(int set){
        if (msgsts ==0) {
            stepcnt = set;
        } else {
            
        }
    }
    
    public static int msgact(int kindofmessage){        //msgnoが"99"だと、メッセージ格納変数をリセットする。
//        stepcnt;
        msgdb.msgno = stepcnt;
        
        if (kindofmessage ==0) {         //処理用にメッセージを代入する処理。("0"…オープニング、"1"…序盤、"2"…中盤、"3"…終盤、"9"…ボス戦、)
            nowmsg = msgdb.thisisamsg();
//        } else if (kindofmessage ==1) {
//            nowmsg = msgdb.murastartmsg();
        } else {
            //特に無し。
        }
        
        if (nowmsg==null) {
            msgsts = 1;
            return stepcnt;
        }
        
        int mpasts = messageprintaction(nowmsg);
        
        if (mpasts ==1) {                              //異常時：文字表示処理が途中で終了した場合。
            msgsts = -1;
        } else if (mpasts ==0) {
            if (msgdb.msgdbsts ==0) {                  //正常時：文字表示処理が正常に行われている最中。
                msgsts = 0;
//                stepcnt = 0;
            } else if (msgdb.msgdbsts ==1) {           //正常時：文字表示処理が正常に行われた場合。(文末)
                msgsts = 1;
            } else if (msgdb.msgdbsts ==9) {           //例外時：メッセージDBクラスに設定されているメッセージの数と指定のメッセージコードが有っていない場合。
                msgsts = 9;
            } else if (msgdb.msgdbsts ==99) {          //例外時：ここの処理には流れないと思われる。
                msgsts = 99;
                stepcnt =-99;                
            } 
        } else {
            //一時的に未定。(多分無い。)
        }
        
        return stepcnt;
    }
    
    public static int messageprintaction(String msg){             //メッセージを1文字ずつ表示させる処理。
    
        //1文字の表示用変数
        char hyoujimoji;
        int cnt=0;
        
        for(cnt =0 ; cnt < msg.length() ; cnt++){
            hyoujimoji = msg.charAt(cnt);
            
            System.out.print(hyoujimoji +" ");
            
            wait2.waitmain(175);
            if (wait2.wait ==1){
                endz.ends(9);
            }
        }
    if (cnt == msg.length()) {
        System.out.println(kai1.kaigyou());
        return 0;
    } else {
        System.out.println("メッセージの表示中に問題が発生しました。ゲームを終了します。");
        return 1;
    }
    }
    
}
class messagezdb{        //メッセージを格納するクラス。
    
    //変数定義
    static int msgno;   //指定のメッセージを指し示すNo.
    private String msg;   //提供するメッセージを格納する変数。
    int msgdbsts;      //メッセージdbのステータスコード。
    
    int opmsgvolume = 10 ;          //オープニングメッセージのメッセージ数。(メッセージの追加・削除した場合は、ここを変更する。)

    public String thisisamsg(){      //メッセージ生成メソッド実行とそのメッセージを渡すメソッド。
        openingmsg();
        
        return this.msg;
    }
    
    private void openingmsg(){      //オープニングメッセージ
        
        int opmsgno = msgno;
        //メッセージ格納用配列。
        String opmsg[] = new String[opmsgvolume];      //初期値は10で。必要に応じて増減してちょ。
        
        //メッセージ格納。
        opmsg[0]="ダミーメッセージ(テスト用)";     //本処理では使用しないメッセージ。表示テスト用。
        opmsg[1]="\"呼び覚まれし勇者よ！！\"";
        opmsg[2]="未だ名も無き非力な男に、とある声が掛かる...。";
        opmsg[3]="とある1人の果敢な勇者の\"物語\"の幕は開けたのであった。";
        
        //メッセージ送信処理。
        if (opmsgno == 99) {
            opmsgno =0;   //リセット
            msgdbsts = 0;
            this.msg = "メッセージ無し。";
//            return "メッセージ無し。";
        } else if (opmsgno <opmsgvolume){      //正常：文中。
            this.msg = opmsg[opmsgno];
            msgdbsts = 0;
//            return this.msg;
        } else if (opmsgno == opmsgvolume) {      //正常：文末。
            opmsgno =0;   //リセット
            msgdbsts = 1;
            this.msg = "メッセージ無し。";
//            return "メッセージ無し。";
        } else if (opmsgno >opmsgvolume) {
            msgdbsts = 9;
            this.msg = "読み込むメッセージは有りません。";
//            return "読み込むメッセージは有りません。";
        }else {             //ここの処理には流れないと思われる。
            msgdbsts = 99;
//            return opmsg[0];            
        }
    }
}
class charadatabase {      //ここには登場するキャラの情報を格納している。このクラス内での変更はcngメソッドのみ。

    //変数定義
    private String yakushoku = "";
    private String basenamae;
    private String baseseibetu;
    private int basegender;
    private String seibetuname[] = {"男性", "女性"};

    private int sts;      //どの処理に流れたかを示すコード。
    private static int tourokusts = 0;    //登録・参照時のステータス。0:正常処理 9:異常発生

    private String msg01 = "正常に登録されました。";
    private String msg02 = "正常に参照しました。";
    private String msgE00 = "登録の許可が有りません。登録処理を終了します。";
    private String msgE01 = "登録時にエラーが発生しました。登録処理を終了します。";
    private String msgE02 = "データ参照時にエラーが発生しました。参照処理を終了します。";

    public void cngbasedata(String henkou, int henkoutaishou, int cngflg) {      //情報変更メソッド。情報変更はここでのみ。

        sts = henkoutaishou;

        if (cngflg == 1) {
            if (henkoutaishou == 1) {
                basenamae = henkou;
                System.out.println(msg01);
//                  return tourokusts;
            } else if (henkoutaishou == 2) {
                baseseibetu = henkou;
                System.out.println(msg01);
            } else {
            }      //条件追加
        } else {
            String msgno = "";
            switch (sts) {
                case 1:
                    msgno = msgE01;
                    break;
                case 2:
                    msgno = msgE02;
                    break;
                default:
                    msgno = msgE00;
            }
            System.out.println(msgno);
            tourokusts = 9;
//            return tourokusts;
        }
    }

    public String getbasedata(int getcode) {      //情報参照メソッド。
        if (getcode == 1) {
//            System.out.println(basenamae);
            return basenamae;
        } else if (getcode == 2) {
            basegender = Integer.parseInt(baseseibetu) - 1;
//            System.out.println(seibetuname[seibetu]);
            return seibetuname[basegender];
        } else {
        }
        return null;
    }

    public void showbasedata() {
        if (!yakushoku.isEmpty()) {
            System.out.println(yakushoku + ":" + basenamae + "のステータス");
        } else {
            System.out.println(basenamae + "のステータス");
        }
        System.out.println("1.名前：" + basenamae);
        System.out.println("2.性別：" + seibetuname[basegender]);
    }

    public static int getbasests() {
//        System.out.println(tourokusts);
        return tourokusts;
    }
}
class charashubase{      //ここにはキャラの職業の基本データを格納するクラス。
    //ステータス対応の変数定義
    private String name;
    private String seibetu;
    private String yakushoku;
    private int level;
    private int heart_point;
    private int magic_point;
    private int attack;
    private int defense;
    private int magic_attack;
    private int magic_defense;
    private int speed;

    charashubase(int yakushoku) {
        if (yakushoku == 0) {      //勇者
            this.yakushoku = "勇者";
            level = 0;
            heart_point = 12;
            magic_point = 5;
            attack = 8;
            defense = 3;
            magic_attack = 18;
            magic_defense = 14;
            speed = 6;
        } else if (yakushoku == 1) {       //武闘家
            this.yakushoku = "武闘家";
            level = 0;
            heart_point = 23;
            magic_point = 2;
            attack = 13;
            defense = 5;
            magic_attack = 3;
            magic_defense = 5;
            speed = 12;
        } else if (yakushoku == 2) {       //魔法使い
            this.yakushoku = "魔法使い";
            level = 0;
            heart_point = 8;
            magic_point = 38;
            attack = 7;
            defense = 8;
            magic_attack = 58;
            magic_defense = 83;
            speed = 18;
        }
    }
        void nameseibetuputmathod(int cngflg,String namae,String gender){

        if (cngflg ==1) {
            name = namae;
            seibetu = gender;
            System.out.println("名前と性別の登録が完了しました。");
        } else {

        }
        }
        void showplayersts(){
            System.out.println("名前："+name+"のステータス");
            System.out.println("職業："+yakushoku);
            System.out.println("HP："+heart_point);
            System.out.println("MP："+magic_point);
            System.out.println("攻撃力："+attack);

        }
}
class charabase{
    
    //変数定義
    private static String namae;
    private static String seibetu;
    static int cngflg;
    private static int sts=0;
    
    //メソッドの定義
    static nyuuryoku nyuuryoku = new nyuuryoku();
    static nyuuryokucheck nyuuryokucheck = new nyuuryokucheck();
    
    public static String charamakebase1name_gender(int rqst){      //rqst：0 name, 1 gender
        
        String namekari;
        String seibetukari ="";
        String namaeseibetu;
        int gender;
        boolean handan;
        int name_gender;
        
        String msg="";
        
        int i=1;
        
        if (rqst ==0){
            msg="名前を\"10文字以内で\"入力して下さい。数字は使用出来ません。";
        } else if (rqst ==1){
            msg="性別を\"1.男性\"か\"2.女性\"で入力して下さい。1,2以外は使用出来ません。";
        } else {
            i = 3;
        }
        
        name_gender = rqst;
        
        while(i <4){
            
            nyuuryoku.inputwords(msg);
        
            namaeseibetu = nyuuryoku.word;
            nyuuryokucheck.ckshori(namaeseibetu,name_gender);
        
            handan = nyuuryokucheck.hanndann;
        
            if (handan){
                if (rqst ==1){
                    seibetukari = namaeseibetu;
                    if (namaeseibetu.equals("1") | namaeseibetu.equals("１")){
                        namaeseibetu = namaeseibetu.concat(".男性");
                    } else if (namaeseibetu.equals("2") | namaeseibetu.equals("２")){
                        namaeseibetu = namaeseibetu.concat(".女性");
                    } else {
                        System.out.println("1.男性\"か\"2.女性\"で入力して下さい。1,2以外は使用出来ません。");
                        i++;
                        continue;
                    }
                }
//                if (nyuuryokucheck.hanndannans ==0) {
                    yesno.yesno(namaeseibetu);
                    if(nyuuryoku.shownyrksts()==0){       //入力内容の確認で"Y"の場合。
                        i = 0;
                        cngflg = 1;      //変更フラグを"1"にする。(登録処理。)
                        if (rqst ==0){
                            namae = namaeseibetu;
                            
                        } else if (rqst ==1) {
                            seibetu =  seibetukari;
                        }
//                        break;
                        return "OK";
                    } else if (nyuuryoku.shownyrksts()==1){       //入力内容の確認で"N"の場合。
                        i++;
                        continue;
                    } else if (nyuuryoku.shownyrksts()==9){       //入力内容の確認で"Y","N"以外が入力された場合。
                        i++;
                        continue;
                    }
//                }
            } else {
                if (nyuuryokucheck.hanndannans ==9){
                    endsshori.ends(9);
                } else if (nyuuryokucheck.hanndannans ==1){
                    i++;
                    continue;
                }
            }
                System.out.println("正常の値を入力して下さい。");
                i++;
        }
        if (i >=4){
            System.out.println("正常な値が入力されませんでした。");
            System.out.println("もう一度最初からやり直して下さい。");
            sts = 1;
        }
        return "error";
    }
    public static String showsts(int code){
        switch(code){
            case 0:
                return namae;
            case 1:
                return seibetu;
            default:
                return null;
        }
    }
    public static int showstscd(){
        return sts;
    }
}
class nyuuryoku{
    
    public static String word;
    public static int ints;
    static String aisatu;
    private static int nyuuryokusts;
    
    public static void inputwords(int input){     //入力メソッドのオーバーロード1
        endsshori endz = new endsshori();
        
        try{
            if (input==0) {
                //エンター入力のみ。
                enter();
            } else if (input==1) {
                //入力した文字列を代入する。
                word = inputmain(); 
                nyuuryokusts =0;
            }
        }catch(IOException e){
            System.out.println("入力の受付が出来ませんでした。お手元の入力環境を確認し、再度最初から実行して下さい。");
            nyuuryokusts =9;
            endz.ends(9);
        }
    }
    public static void inputwords(String aisatuwords){     //入力メソッドのオーバーロード2
        aisatu = aisatuwords;
        System.out.println(aisatu);   
        
        inputwords(1);
    }
    public static void inputwords(){     //入力メソッドのオーバーロード3
        
        inputwords(1);
    }
    private static String inputmain() throws IOException {
        String word1 = "";
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word1 = br.readLine();
        
        return word1;
    }
    private static void enter() throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }
    static int shownyrksts(){
        return nyuuryokusts;
    }
    static int cngnyrksts(int sts){
        nyuuryokusts = sts;
        return nyuuryokusts;
    }
}
class intinput extends nyuuryoku{      //入力された文字列を数字に変換する。
    //変数定義
    public static int nyuuryokuint;
    private static int intinputsts =0;
    
    //メイン処理
    public static void inputint(){
        inputwords();
        
        intwords(word);
        
        if (intinputsts ==1){
            //数字に変換出来ない数字が入力された場合。
        } else if (intinputsts ==0) {
            ints = nyuuryokuint;
        } else {
            
        }
    }
    
    public static void intwords(String inputwords){
        try{
            intck(inputwords);
        }catch(NumberFormatException e){
            System.out.println("英文字は受け付けておりません。数字のみで入力して下さい。");
            intinputsts =1;
        }
    }
    static void intck(String inwords){
        nyuuryokuint = Integer.parseInt(inwords);
    }
    static int showiptsts(){
        return intinputsts;
    }
}
class yesno extends nyuuryoku{
//    private static String aisatu = "";
    public static void yesno(String mojishu){
        
        System.out.println("入力内容は\""+ mojishu +"\"で間違いはないでしょうか? →'Y'、'N' ");
        inputwords(1);
        
        if (word.equals("Y") | word.equals("y")) {
            System.out.println("\""+mojishu+"\"で登録しました。");
            cngnyrksts(0);
        } else if (word.equals("N") | word.equals("n")) {
            System.out.println("登録しませんでした。");
            cngnyrksts(1);
        } else {
            System.out.println("指定の文字以外が入力されました。正しい値を入力して下さい。");
            word ="";
            cngnyrksts(9);
        }
    }
}
class nyuuryokucheck{
    
    //変数定義
    public static String moji;
    public static int suuji;
    public static int ketasuu;
    public static int inputsts;
    
    //入力チェック処理で使用する変数
    public static boolean hanndann;
    public static int hanndannans;
    
    //チェック済みの値を格納する変数。(※変換時に正常値以外や引数が間違えていた場合、"error" の文字列が格納される。
    public static String ckzumimojierror = "";
    public static String ckzumimoji;
    public static int ckzumiint;
    public static String ckzumiinterror = "";
    
    static seikihyougen seiki;
    static hyouji prt = new hyouji();
    
    //メッセージ定義
    private static String msgE1 = "今回の入力では数字は使用出来ません。数字以外で入力して下さい。";
    private static String msgE2 = "今回の入力では英文字・記号等は使用出来ません。数字のみで入力して下さい。";
    private static String msgE3 = "数字入力エラー発生！";
    private static String msgE4 = "英字入力エラー発生！";
    private static String msgE5 = "桁数超過エラー発生！";
    private static String msgE9 = "係数エラー発生！";
    private static String msgE10 = "1文字以上は入力して下さい。";
    private static String msgE99 = "使用出来ない文字が入力されました。";
    private static String msgE100 = "入力処理を完了出来ませんでした。";
    private static String msg99 = "入力された文字は使用出来ます！";
    private static String msg100 = "入力が完了しました。";
    
    private static String mojiretuhanndanmethod(int mojishucode){       //mojishunote:※入力したい文字種の区別コード 。0…数字以外の英文字等、1…数字のみ
//        char a;
        String moji1;      //文字種を判断する為の1文字格納用変数。
        int nowmoji;
        
        if (moji.length() <=10 && moji.length() >0){      //桁数確認。10桁以内の場合。
            for (nowmoji =0;nowmoji <moji.length();nowmoji++){
//                a = moji.charAt(nowmoji);
                moji1 = moji.substring(nowmoji,nowmoji+1);
                seiki = new seikihyougen(moji1);
//                System.out.println(moji1);
                
                if (mojishucode ==0) {      //英文字判断処理
		            if (seiki.m) {      //半角数字が有った場合。
//			            System.out.println("名前に数字は使用出来ません。数字以外で入力して下さい。");
			            inputsts = 1;
			            break;
		            } else {      //半角数字が無い場合。
		                if(seiki.m2) {      //全角数字が有った場合。
//			                System.out.println("名前に数字は使用出来ません。数字以外で入力して下さい。");
			                inputsts = 1;
			                break;		                
		                } else {      //半角・全角数字が無かった場合。(正常値：英文字・記号)
			                inputsts = 0;		                
		                }
		            }
		        
                } else if (mojishucode ==1) {      //数字判断処理
		
		            if (!seiki.m) {      //半角数字以外が見つかった場合。
		                if(!seiki.m2) {      //全角数字以外が見つかった場合
//			                System.out.println("英文字・記号等は使用出来ません。数字のみで入力して下さい。");
			                inputsts = 1;
			                break;
		                } else {}
		            } else {      //半角・全角数字で構成されていた場合。(正常値：数字)
		                inputsts = 0;		                
		            }
                } else {      //判断処理(引数例外処理)
                    prt.printmoji(msgE9);
                    System.out.println("スタッフをお呼び下さい。");
                    inputsts =9;
                    break;
                }
            }
            
            if (nowmoji == moji.length() && inputsts ==0){
                prt.printmoji(msg99);       //正常メッセージ。
		        return moji;
		    } else if (inputsts ==1) {
		        if (mojishucode ==0){
		            prt.printmoji(msgE4);
		        } else if (mojishucode ==1){
		            prt.printmoji(msgE3);
		        } else {}
		        return moji;
		    } else if (inputsts ==9){
		        // メインに戻ったら、終了処理を流す。
		        return "error";
		    }
        } else if (moji.length() >10) {      //桁数確認。11桁以上の場合。(0桁未満という値は存在しないはずなので気にしなくて良い。)
            inputsts =7;
            prt.printmoji(msgE5);
            return moji;
        } else if (moji.length() == 0){
            prt.printmoji(msgE10);
            inputsts =7;
            return moji;
        } else {
            
        }
        return "error";     //仮置き
    }
    public static void ckshori(String inputwordskari,int hanndannshubetu){
        
        //変数定義
//        boolean hanndann;
//        int hanndannans;
        
        if (hanndannshubetu ==0){
            mojick(inputwordskari);
        } else if (hanndannshubetu ==1){
            suujick(inputwordskari);
        } else {
            hanndann = false;
            hanndannans = 9;
        }
        
        //マッチメゾット定義
        Pattern ptn = Pattern.compile("error");
        Matcher mojimtr = ptn.matcher(ckzumimojierror);
        Matcher intmtr = ptn.matcher(ckzumiinterror);
        
        if (mojimtr.find()){  //2つの変数にerrorの文字列が入っていた場合、falseを、それ以外はtrue を投げる。
            if (ckzumimojierror.equals("error")){
                hanndann = false;
                hanndannans = 9;
//                System.out.println("test1");
            } else {
                hanndann = false;
                hanndannans = 1;
//                System.out.println("test2");
            }
        } else if (intmtr.find()){
            if (ckzumiinterror.equals("error")){
                hanndann = false;
                hanndannans = 9;
//                System.out.println("test3");
            } else {
                hanndann = false;
                hanndannans = 1;
//                System.out.println("test4");
            }            
        } else {
                hanndann =true;
                hanndannans = 0;
//                System.out.println("test5");
        }
        
        //変数の初期化
        if (!ckzumimojierror.isEmpty()){
            ckzumimojierror = "";
        } else if (!ckzumiinterror.isEmpty()) {
            ckzumiinterror = "";
        }
    }
    private static void mojick(String mojick){
        
        //変数定義
        String nyuuryokumojick;
//        String mojickok;
        
        moji = mojick;
        
        nyuuryokumojick = mojiretuhanndanmethod(0);
        
        if (inputsts ==0){          //正常処理
//            prt.printmoji(msg99);
            ckzumimoji = nyuuryokumojick;
        } else if (inputsts ==1 | inputsts ==7) {          //桁数違いや、入力間違い。(再入力処理)
            prt.printmoji(msgE99);
            ckzumimojierror = "input error";
        } else if (inputsts ==9) {          //処理時に異常発生した場合。文字か数字等の文字種を指定する引数が間違っていた場合。ここで処理終了させる。
            ckzumimojierror = "error";
        }
    }
    private static void suujick(String suujick){
        
        //変数定義
        String nyuuryokuintck;
//        int suujickok;
        
        //メソッド定義
        intinput intinput = new intinput();
        
        moji = suujick;
        
        nyuuryokuintck = mojiretuhanndanmethod(1);
        
        if (inputsts ==0){
            prt.printmoji(msg99);
            
            intinput.intwords(nyuuryokuintck);
            
            if (intinput.showiptsts() ==1){
                ckzumiinterror = "input error";
            } else if (intinput.showiptsts() ==0){
                ckzumiint = intinput.nyuuryokuint;
                nyuuryoku.ints = ckzumiint;      //入力のメインクラスの変数に代入する。
            }
        } else if (inputsts ==1 | inputsts ==7) {
            prt.printmoji(msgE99);
            ckzumiinterror = "input error";
        } else if (inputsts ==9) {
            ckzumiinterror = "error";
            //引数例外
        }
    }
}
class seikihyougen{
    static boolean m;       //半角数字
    static boolean m2;       //全角数字
    
//    seikihyougen(int suuji1){
//        seikihygn(suuji1);
//    }
    seikihyougen(String moji1){
        seikihygn(moji1);
    }
    private static void seikihygn(String moji){
        
        Pattern p = Pattern.compile("\\d");      //半角数字
		Pattern q = Pattern.compile("１|２|３|４|５|６|７|８|９|０");      //全角数字
		Matcher mtr = p.matcher(moji);
		Matcher mtr2 = q.matcher(moji);
		
		m = mtr.find();            //boolean型：true 半角数字が有る。false 半角数字が1文字も無い。
		m2 = mtr2.find();            //boolean型：true 全角数字が有る。false 全角数字が1文字も無い。
    }
}
class hyouji{
    public static void printmoji(String msg){
        System.out.println(msg);
    }
}
//class keyinput implements KeyListener{
//    String keyinput;
    
//    public void init(){
//        addKeyListener(this);
//    }
    
//    @Override
//    public void keyTyped(KeyEvent e){
//        switch (e.getKeyCode()) {
//        case KeyEvent.VK_ENTER:
//            keyinput = "enter";
//    }
//    }
    
//    @Override
//    public void keyPressed(KeyEvent e){}      //現在実装していない
    
//    @Override
//    public void keyReleased(KeyEvent e){}      //現在実装していない
//}
class tennmetu{
    //変数定義
    static String tenmetustr;
    static String tenmetustr2;      //空白埋めされた文字列を格納する変数。
    static int moji;
    private static int tnmtstop = 0;
    
    //メソッド定義
    static wait wait1 = new wait();
    
    public static void ts(int ts){
        if (ts==1){
            tnmtstop = 1;
        } else {
            tnmtstop = 0;
        }
    }
    
    public static void tm(String str,int mojikasho){
        tenmetustr = str;
        moji = mojikasho;
        String tenmetustrmoto ="";
        String tenmetu;
        StringBuilder space = new StringBuilder();
//        StringBuilder tenmetu = new StringBuilder(65536);
        short k = 0;
        
        for(int i =1;i <=moji;i++){
            space.append(" ");
        }
//        tenmetu.append(tenmetustr.substring(0,tenmetustr.length()-moji));
        tenmetu = tenmetustr.substring(0,tenmetustr.length()-moji);
        tenmetustrmoto = tenmetu;
//        System.out.println(tenmetustrmoto);
        
        tenmetustr2 = tenmetu.concat(new String(space));
		
	while(tnmtstop ==0){
	    
	    System.out.print("\r");
	
	    if (k%2 == 0){
	    	System.out.print(tenmetustr);
	    } else {
	    	System.out.print(tenmetustr2);
	    }
	        wait1.waitmain(500);    //点滅速度の設定。500が丁度良い感じ？
	        k++;
	        
	        if (k >32766) {       //桁数オーバーを回避する為の処理。
	            k=0;
	        }
	    }
    }
}
class multithread extends Thread{
    //変数定義
    static String mojiretu;
    static int mojisuu;
    
    //メソッドの定義
    static tennmetu tennmetu = new tennmetu();
    static nyuuryoku nyuuryoku = new nyuuryoku();
//    keyinput keyinput = new keyinput();
    
    public static void multith(String moji,int keta){
        mojiretu = moji;
        mojisuu = keta;
        
        tennmetu.tm(mojiretu,mojisuu);
    }
//    public void start();

    @Override
    public void run(){
//        nyuuryoku.aisatu = null;
        
//        while(true){
        nyuuryoku.inputwords(0);
//        System.out.println(nyuuryoku.word);
        
//            if (keyinput.keyinput == "enter") {
                int ck = 1;
                tennmetu.ts(ck);
                
//                break;
//            } else {
//            }
//        }
    }
}
class kaigyo{
    public static String kaigyou(){
        String kai = System.getProperty("line.separator");
        return kai;
    }
}
class wait{
    static int waitjikan =0;
    static int wait;
    
    public static void waitmain(int wtime){
        waitjikan = wtime;
        
        try{
        waittime();
        }catch (InterruptedException e) {
            System.out.println("処理時に問題が発生しました。(wait処理)");
            wait =1;
        }
    }
    
    static void waittime() throws InterruptedException{
//        int wait=wtime;
            Thread.sleep(waitjikan);     //指定の秒数だけ処理を停止する。
    }
}
class endsshori{
    public static void ends(int endcd){
        
        int ends=0;      //終了コード
        
        if (endcd ==0) {
            System.out.println("処理を終了します。");       //通常のゲーム以外の方法で処理を終了する指示が出た時。
            ends = 0;
        } else if (endcd ==1) {
        } else if (endcd ==9) {
            System.out.println("処理中にエラーが発生しました。処理を終了します。");       //ゲーム中や処理中にエラーが発生した時。
            ends = 9;
        }
        
    if (ends == 9) {
        System.exit(0);
    }
    }
}