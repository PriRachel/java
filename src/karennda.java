package com.homejp;

import java.io.*;

class karennda {
    
//変数設定箇所
static int sts =0;
static int seireki =0;
//static int end = 0;
static int uruudays =0;
    
    public static void main(String[] args){
        //変数定義
        int nyrkkisu = 0;
        String word1 ="";
        
        //改行メソッド定義
        kaigyou kaigyou1 = new kaigyou();
//        kaigyou1.kai;

        //システム終了メソッド定義
        shuuryou shru = new shuuryou();
        
        //メッセージ表示
        aisatubun aisatu = new aisatubun();
        aisatu.aisatu(1);
        
        //メイン処理(入力・正常値確認処理)
//        while ()
//        //西暦入力・判断処理        クラスのコーディングが出来なかった為、別の手順で実装する。
//        uruuhandan urhdn = new uruuhandan();
//        int seireki = urhdn.uck;   //入力された西暦
//        urhdn.uruhdn;   //うるう年かどうかの判断(true、false)

        while(true) {

        //西暦入力処理
        if (nyrkkisu == 0) {
        word1 = "うるう年かどうかを判定します。4桁の数字(整数のみ)を入力して下さい。(1873～)";
        } else if (nyrkkisu >= 1) {
        word1 = "入力時に不備が有りました。再度入力して下さい。(1873～)";
        }
        
        nyuuryoku nyrk = new nyuuryoku();
        try{
            seireki = nyrk.year1(word1);
        }
        catch (IOException e) {
            System.out.println("入力の処理を終了します。お手元の環境を確認し、再度実行し直して下さい。");
                break;
        }
        
        //ステータス判定
        if (nyrkkisu <=3) {
            if (sts == 9) {
                nyrkkisu++; //通常エラー。主に入力処理時に正常値が入力されなかった場合にこのステータスコードを代入する。
            } else if (sts == 0) {
                System.out.println("入力を受け付けました。");
                break; //正常時はこのコードになる。問題なし。
            } else if (sts <0) {
                System.out.println("入力の処理を終了します。お手元の環境を確認し、再度実行し直して下さい。");
                break;
            } else {
                aisatu.aisatu(2);
                nyrkkisu++;
            }
        } else if (nyrkkisu >3) {      //5回以上繰り返したら、処理を終了させる。
            aisatu.aisatu(3);
            shru.ends(9);
        }
        
        }   //whileの閉じ文
        
        
        if (sts == 9) {      //複数回入力を間違えた場合の処理
            aisatu.aisatu(3);
            shru.ends(9);
        } else if (sts <0) {      //入力時に例外処理(IOException)が走った時。
            aisatu.aisatu(5);
            shru.ends(9);
        } else {      //正常の場合。
        }
    
        //カレンダー登録処理
//    if (sts == 0) {        //入力された西暦が正常値場合、カレンダー登録処理に入る。
    
        //うるう年用の変数
        int uruuyear = 0;
    
        //うるう年のチェック処理
        uruucheck urukaku = new uruucheck();
        boolean urubool = urukaku.uruck(seireki);      //うるう年の結果を代入。
    
        if (urubool) {
            uruuyear = 1;
            System.out.println("入力された西暦" + seireki + "年はうるう年です。");
        } else {
            uruuyear = 0;
            System.out.println("入力された西暦" + seireki + "年はうるう年では無く、平年です。");
        }
        
        //月日の確認用に変数に格納。
        uruudays = uruuyear;
        
        //カレンダー登録確認処理
        nyuuryokubase nrkbs1 = new nyuuryokubase();
        
        int krst = 0;
        
        while(krst <3) {
            try{
            nrkbs1.msg1 = "カレンダーの登録を行いますか? →'Y'、'N' ";
            String nr1 = nrkbs1.nryk();
            
            if(nr1.equals("Y") || nr1.equals("y")) {
                System.out.println("承知致しました。" + kaigyou1.kaigyou() + "それではカレンダーの登録処理に移行します。");
                break;
                
            } else if (nr1.equals("N") || nr1.equals("n")) {
                nrkbs1.msg1 = "カレンダーの登録を行わずに、日付・曜日検索システムを終了しますか? →'Y'、'N' ";
                String nr2= nrkbs1.nryk();
            
                if(nr2.equals("Y") || nr2.equals("y")) {
                    System.out.println("承知致しました。" + kaigyou1.kaigyou() + "それではシステムの終了処理に移行します。");
                    shru.ends(9);
                } else if (nr2.equals("N") || nr2.equals("n")) {
                    krst++;
                } else {
                    aisatu.aisatu(2);
                    krst++;
                }
            } else {
                aisatu.aisatu(2);
                krst++;
            }
            }
            catch(IOException e) {
                shru.ends(9);
            }
        }
        
        if (krst >=3){
            aisatu.aisatu(3);
            shru.ends(9);
        }
        
        //曜日設定用の変数
        int youbiuruu = 0;
        double youbiuruu1 =0D;
        
        //うるう年の有無計算処理
        int uruuyear1 = seireki;      //計算用に代入する。
        
        if (uruuyear1 <=1900) {
            youbiuruu1 = (uruuyear1 - 1873 ) * 1.25 + 2;      //1873年の元旦は"水曜日"なので、1873年の曜日配列に当てはめると"2"になる。
        } else if (uruuyear1 >1900 | uruuyear1 <=2001) {
            youbiuruu1 = (uruuyear1 - 1901 ) * 1.25 + 1;      //1901年の元旦は"火曜日"の為、1873年の曜日配列に当てはめると"1"になる。
        } else if (uruuyear1 >2001) {
            youbiuruu1 = (uruuyear1 - 2002 ) * 1.25 + 1;      //2002年の元旦は"火曜日"の為、1873年の曜日配列に当てはめると"1"になる。
        } else {     //今のところ特になし。
        }
        
        youbiuruu = (int)youbiuruu1;
        
        //曜日配列の要素を求める。
        youbiuruu = youbiuruu % 7;
        
//        //デバッグ用の表示処理
//        System.out.println(youbiuruu);
        
//        //曜日配列の要素代入
//        youbiuruu = youbiuruu1;
        
////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////// ↓過去のコード//////////////////////////////////////////////////////////

//        shuuryou shury = new shuuryou();       //終了処理メソッドを呼び出す。
//        shury.yn();
        
//        if (ans.equals("Y") || ans.equals("y")) {
//            shuuryou exitshori = new shuuryou();
//                exitshori.ans = 0;
//        } else if (ans.equals("N") || ans.equals("n")) {
//            shuuryou exitshori = new shuuryou();
//                exitshori.ans = 1;
//        } 
        //終了処理_end_
        
//        catch (NumberFormatException e) {
//            System.out.println("西暦は数字で入力して下さい。もう一度入力し直して下さい。");
//        }
/////////////////////////////////↑過去のコード_ここまで//////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        //カレンダー用の配列を作成
//        int [] tuki = new int[12];
//        int [] hiniti = new int[31];
//        String[][] kare = new String[13][32];      //←これでは間違い。どういう風に初期化されているか気になる。
        String kare[][] = new String[13][32];
        //曜日のデータを配列に登録。
        String [] youbi = {"月曜日","火曜日","水曜日","木曜日","金曜日","土曜日","日曜日"};
        int aa;
        int bb;
        int bi =0;    //曜日用の変数
        int getumatu =0;    //各月の日数用の変数
        int youbi1 = 0;      //曜日の配列用の変数
        
        //カレンダーの月日を登録。
        for (int a = 1 ; a < kare.length ; a++) {
//            aa = tuki.length;
            
            //各月の日数を計算する。
            if (a == 2) {            //2月の場合
                getumatu = 28 + uruuyear;
            } else if (a == 4 | a == 6 | a == 9 | a == 11) {
                getumatu = 30;       //4月、6月、9月、11月の場合
            } else {
                getumatu = 31;       //それ以外の場合
            }
            
            
            
            for (int b = 1 ; b <= getumatu ; b++) {
                youbi1 = youbiuruu + bi;
//                System.out.println(youbi1);
                
                if (youbi1 <7 ) {
                    //何もしない。
                } else if (youbi1 >= 7) {
//                      if (bi == 364) {
//                    System.out.println("カレンダーの設定が完了致しました。");                        
//                    }
                    youbi1 = (youbi1 % 7);
                } else if (bi >= 367) {       //配列の登録処理の仕様により12月31日で登録が止まるので、この先の処理には流れない。
                    youbi1 =0;
//                    System.out.println("カレンダーの設定が完了致しました。");
                    break;
                }

                //曜日の登録処理_start_
                String dayweek = youbi[youbi1];
                kare [a][b] = dayweek;
                //曜日の登録処理_end_
                
                bi++;
                
//                System.out.println(seireki + "年"+ a + "月" + b + "日の曜日は、→" + kare [a][b] + "です。" + bi);      //多分、毎月の月末の曜日が表示されるはず…。
                }
            
            if (bi == 365) {
                System.out.println("カレンダーの設定が完了致しました。");                        
            }
        }
//    } else if (sts == 9) {      //複数回入力を間違えた場合の処理
//        aisatu.aisatu(3);
//        shru.ends(9);
//    } else if (sts <0) {      //入力時に例外処理(IOException)が走った時。
//        aisatu.aisatu(5);
//        shru.ends(9);
//    } else {
//    }
    
    //曜日検索処理_start_
    
    nyuuryokubase nrkbs2 = new nyuuryokubase();
    mdck mdck1 = new mdck();
    
    //検索日付入力処理
//    StringBuffer kskdays = new StringBuffer();
    String kskdays = "";
    String nb3 ="";
    int ybks = 0;
//    int ybksck = 0;
    int kenskdays = 0;
    int kskmth = 0;
    int kskdys = 0;
    
    //入力処理用変数(4桁専用)
    String kskmth1="";
    String kskdys1="";
    int ybkssts=0;
    
    int ks1 =0;
//    int ks2 =0;
    
    System.out.println("これから日付・曜日検索機能を開始します。");
    
    while(ks1 <3) {
    
    int ks2 =0;
    //入力処理
    nrkbs2.msg1 = "検索したい日付を4桁の数字を入力して下さい。 (例：8月31日 → 0831)";
    try{
    nb3 = nrkbs2.nryk();
    }catch(IOException e) {
        aisatu.aisatu(5);
        shru.ends(9);        
    }
        
    ybkssts = mdck1.mdck1(nb3);

    if (ybkssts == 0) {
        aisatu.aisatu(10);
        ks2 =1;
//        break;
    } else if (ybkssts == 9) {
//        aisatu.aisatu(2);
        ks1++;
    } else if (ybkssts < 0) {
        shru.ends(9);  //処理時にエラー発生した場合は、そこで処理を停止する。
    } else {
        System.out.println("月日の確認出来ませんでした。もう一度入力して下さい。");
        ks1++;
    }
    
    if (ks2 ==1 ) {

    //検索条件として入力した月日の変数代入
//    kskdays = mdck1.mmddck;
    kskmth = mdck.monthnum;       //検索用：月
    kskdys = mdck.daysnum;        //検索用：日
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////過去のソース_ここから//////////////////////////////////////////////////////////////    
//    while(ybks <3) {
//        try{
//            nb3 = nrkbs2.nryk();
//        	kskdays.append(nb3.toString());
        	
//            if (nb3.length() ==4) {
//                aisatu.aisatu(10);
//                break;
//            } else if (nb3.length() ==2){
//                if (nb3>12 | nb3<32)
//                System.out.println("カレンダーの設定が完了致しました。");
//            }else {
//                aisatu.aisatu(2);
//                nrkbs2.msg1 = "桁数超過・不足の文字列は受け付けておりません。4桁の数字のみを入力して下さい。" ;
//                ybks++;
//                continue;
//            }
            
//        	kskdays = nb3;
        	
//        	System.out.println(kskdays);
//            kenskdays = Integer.valueOf(kskdays.toString());
//        }
//          catch(IOException e) {
//            shru.ends(9);
//        }catch(NumberFormatException e) {      //英字判断
//            aisatu.aisatu(10);
//          nrkbs2.msg1 = "英字は受け付けておりません。4桁の数字のみを入力して下さい。" ;
//            ybks++;
//            continue;
//        }
////////////////////////////////////////////過去のソース_ここまで//////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
//    kskmth = Integer.parseInt(kskdays.substring(0,2));
//    kskdys = Integer.parseInt(kskdays.substring(2,4));
    
    System.out.println("入力した条件は西暦" +seireki+ "年" +kskmth+ "月" +kskdys+ "日ですね?");
//    System.out.println("宜しければ'Y'を、変更する場合は'N'を押下して下さい。 →'Y'、'N' ");
    
        try{
            nrkbs2.msg1 = "宜しければ'Y'を、変更する場合は'N'を押下して下さい。 →'Y'、'N' ";
            String ans1 = nrkbs2.nryk();
        
            if(ans1.equals("Y") || ans1.equals("y")) {
                System.out.println("確認致しました。" + kaigyou1.kaigyou() + "カレンダーの検索処理に移行します。");
                break;
            } else if (ans1.equals("N") || ans1.equals("n")) {
                nrkbs2.msg1 = "確認出来ませんでした。再度、入力して下さい。";
//                goto LABEL1;      //LABEL1にgotoする。
            } else {
                nrkbs2.msg1 = "確認出来ませんでした。再度、入力して下さい。";
                ybks++;
            }
        }
        catch(IOException e) {
            shru.ends(9);
        }
    } else {
    }
    }       //whileの文末文。
    
    // 3回検索条件が揃わなかった場合、システムを終了する。
    if (ybks >=3) {
        aisatu.aisatu(3);
        shru.ends(9);
    }
    
    //検索処理_メイン_start_
    String youbikekka ="";     //曜日の結果を格納する変数。
    
    //曜日配列を検索する。
    youbikekka = kare[kskmth][kskdys];

//    System.out.println(kare[2][3]);
    
    System.out.println("西暦" +seireki+ "年" +kskmth+ "月" +kskdys+ "日の曜日は\"" + youbikekka + "\"です。");
    
    
    //日にち計算処理_開始
    nyuuryokubase nrkbs3 = new nyuuryokubase();
    mdck mdck3 = new mdck();
    nyuuryoku nyrk = new nyuuryoku();
    
    String yn ="";
    int kskmth2;
    int kskdys2;
    String ks ="";
//    String ksyr ="";
    int ksyr1 = 0;
    int ksint =0;
    int ksans1 =0;
    int ksans2 =0;
    int kssts =0;
    int ks11 =0;
    int ks22 =0;
    
    //処理開始のメッセージ。ここで同じ年かどうか聞く。
    System.out.print("これから日付計算を行います。");
    System.out.println("検索したい月日の西暦は、最初に入力した西暦と同じ年でしょか? →'Y'、'N' ");
    
    while(ks11<3) {
    try{
    yn = nrkbs3.nryk();
    }catch(IOException e) {
        aisatu.aisatu(5);
        shru.ends(9);        
    }
    
    if (yn.equals("Y") | yn.equals("y")) {
        ks11 = 0;
        break;
    } else if (yn.equals("N") | yn.equals("n")) {
        ks11 =9;
        break;
    } else {
        aisatu.aisatu(2);
        ks11++;
    }
    } //whileの閉じ文
    
    if (ks11==3 | ks11 ==0){
        System.out.println("最初に入力した西暦を同じ年で計算を行います。");
        ks22=0;
        ks11=0;
    } else if (ks11 ==9) {
        System.out.println("承知しました。それでは別の西暦で登録を行います。");
    } else {
        aisatu.aisatu(5);
        shru.ends(9); 
    }
    
    if (ks11 ==9) {
        nyrkkisu =0;
        
        while(true){
            
            String msg = "計算したい月日の西暦を数字4桁で入力して下さい。(1873～)";
            try{
            ksyr1 = nyrk.year1(msg);
            }
            catch (IOException e) {
                System.out.println("入力の処理を終了します。お手元の環境を確認し、再度実行し直して下さい。");
                    break;
            }
    
            //ステータス判定
        if (nyrkkisu <=4) {
            if (sts == 9) {
                nyrkkisu++; //通常エラー。主に入力処理時に正常値が入力されなかった場合にこのステータスコードを代入する。
            } else if (sts == 0) {
                System.out.println("入力を受け付けました。");
                ks11 = 0;
                ks22 = 1;
                break; //正常時はこのコードになる。問題なし。
            } else if (sts <0) {
                System.out.println("入力の処理を終了します。お手元の環境を確認し、再度実行し直して下さい。");
                shru.ends(9);
            } else {
                aisatu.aisatu(2);
                nyrkkisu++;
            }
        } else if (nyrkkisu >4) {      //5回以上繰り返したら、処理を終了させる。
            aisatu.aisatu(3);
            shru.ends(9);
        }
        }   //whileの閉じ文
        
//        ks22 = 0;
    }
    
//    try{
//        ksyr1 = Integer.parseInt(ksyr);
//    }catch(NumberFormatException e){
//        aisatu.aisatu(5);
//        shru.ends(9);
//    }
    
    if (ksyr1 == seireki) {
        ks22 = 0;
    }
    
    while(ks11 <3) {
    nrkbs3.msg1 = "計算したい日付を4桁の数字を入力して下さい。 (例：2月29日 → 0229)";
    
    try{
    ks = nrkbs3.nryk();
    }catch(IOException e) {
        aisatu.aisatu(5);
        shru.ends(9);        
    }
    
    kssts = mdck3.mdck1(ks);

    if (kssts == 0) {
        aisatu.aisatu(10);
//        ks2 =1;
        break;
    } else if (kssts == 9) {
//        aisatu.aisatu(2);
        ks11++;
    } else if (kssts < 0) {
        shru.ends(9);  //処理時にエラー発生した場合は、そこで処理を停止する。
    } else {
        System.out.println("月日の確認出来ませんでした。もう一度入力して下さい。");
        ks11++;
    }
    }
    
    if (ks11>=3) {
        shru.ends(9);
    }
    
    try{
        ksint = Integer.parseInt(ks);
    }catch(NumberFormatException e){
        aisatu.aisatu(-1);
        shru.ends(9);
    }
    
    //
    kskmth2 = mdck3.monthnum;       //検索用：月
    kskdys2 = mdck3.daysnum;        //検索用：日
    
    //計算メソッド開始
    keisann ksn =new keisann();
    
    if (ks22 >0) {
    
    //うるう年用の配列を作成する。
    int uruu[] = new int[Math.abs(ksyr1-seireki) +1];
    int u =0;
    int h =0;
    int nennsi =0;
    int nennmatu =0;
    int hrt = 0;
    int nissuu=0;
    int urubool2int;
    boolean uruboolhozon;
    boolean urubool2;
    
    for (int i = Math.min(ksyr1,seireki);i <= Math.max(ksyr1,seireki);i++) {
        urubool2 = urukaku.uruck(i);
        if (urubool2) {
            u =1;
        }
        uruu[h] = 365 + u;
        
        h++;
    }
    
    //検索条件の月と最初の月の日数計算_start_
        urubool2 = urukaku.uruck(ksyr1);
        
        if (urubool2) {
            urubool2int = 1;
        } else {
            urubool2int =0;
        }
        
        ksn.uruu = urubool2int;

    if (ksyr1 < seireki) {      //検索条件として指定した(後で入力した)西暦が、最初に入力した西暦より小さい(昔の)場合。
        nennsi = ksn.nissuuksn(kskmth2,kskdys2,1);       //年始からの日数を計算。
    } else if (ksyr1 > seireki) {
        nennmatu = ksn.nissuuksn(kskmth2,kskdys2,2);       //年末までの日数を計算。
    } 
        
        uruboolhozon = urubool2;
    
        urubool2 = urukaku.uruck(seireki);
        
        if (urubool2) {
            urubool2int = 1;
        } else {
            urubool2int =0;
        }
        
        ksn.uruu = urubool2int;
    
    if (ksyr1 < seireki) {
        nennmatu = ksn.nissuuksn(kskmth,kskdys,2);       //年末までの日数を計算。
    } else if (ksyr1 > seireki) {
        nennsi = ksn.nissuuksn(kskmth,kskdys,1);       //年始からの日数を計算。
    }
    
    if (nennsi>=400 | nennmatu>=400){
        aisatu.aisatu(-1);
        shru.ends(9);
    }
    //検索条件の月と最初の月の日数計算_end_
    
    if (uruu.length >=3) {
        for(h=1;h<uruu.length-1;h++){
            hrt += uruu[h];
        }
    } else if (uruu.length <3) {
    }
    
    nissuu = nennsi + hrt + nennmatu;      //合計日数。
    
    System.out.print("西暦" +ksyr1+ "年" +kskmth2+ "月" +kskdys2+ "日は、西暦" +seireki+ "年" +kskmth+ "月" +kskdys+ "日と比べると");
    
    if (ksyr1 < seireki) {
        System.out.println(nissuu-1 + "日前です。");
    } else if (ksyr1 > seireki) {
        System.out.println(nissuu-1  + "日後です。");
//    } else if (sabun ==0) {
//        System.out.println(sabun  + "日です。(同じ日になります。)");
    } else {
        //特になし。
    }
    System.out.println("日数は"+nissuu+"日です。");
//    System.out.println("日数は"+nissuu+"日です。");
    
    }else if (ks22 ==0) {
    
    //
    ksn.uruu = uruuyear;
//    ksn.getumatu1 = getumatu;
    
    //計算開始
    ksans2 = ksn.ksn(kskmth2,kskdys2);       //計算処理時に入力した日付
    ksans1 = ksn.ksn(kskmth,kskdys);       //一番最初に入力した日付
    
    int sabun = ksans2-ksans1;
    
    System.out.print("西暦" +seireki+ "年" +kskmth2+ "月" +kskdys2+ "日は、西暦" +seireki+ "年" +kskmth+ "月" +kskdys+ "日と比べると");

    if (sabun >0 ) {
        System.out.println(sabun + "日後です。");
    } else if (sabun <0) {
        System.out.println(Math.abs(sabun)  + "日前です。");
    } else if (sabun ==0) {
        System.out.println(sabun  + "日です。(同じ日になります。)");
    }
    
    ksn.showks(kskmth2,kskdys2);
    
    }
    
    }      //mainメソッドの終了文
    public static void endshori(){
            //終了ステータスコード設定
        int endsts = 0;
        
        int endkaisuu = 0;
        
        //メッセージ表示
        aisatubun aisatu = new aisatubun();
        aisatu.aisatu(4);
        
        //終了処理_start_
        while(endkaisuu<=2) {
        //入力処理_開始_
            if (endkaisuu > 0) {
            nyuuryokubase.msg1 = "それでは入力して下さい。('Y'、'N')";
            }
            String yn1 = "N"; // 入力格納する変数
        
            nyuuryokubase nb1 = new nyuuryokubase();
            try{
                yn1 = nb1.nryk();       //'Y'と'N'の入力結果が表示される。
            }
            catch(IOException e) {
                System.out.println("入力の処理を終了します。お手元の環境を確認し、再度実行し直して下さい。");            
            }
        
            //終了メイン処理_start_
            if (yn1.equals("Y")) {
                sts = 9;
                shuuryou endshori = new shuuryou();
                endshori.ends(sts);
            } else if (yn1.equals("N")) {
                System.out.println("システムを終了せずに処理を続行します。");
                endsts = 0;
                break;
            } else {
                System.out.println("恐れ入りますが、'Y'か'N'で入力して下さい。");
                endkaisuu++;
            }
        }
        //終了メイン処理_end_
    }
}      //mainクラス(karennda)の終了文。

class kaigyou {        //改行のクラス
    static String kaigyou(){
        String kai = System.getProperty("line.separator");
        return kai;
    }
}
class nyuuryoku {      //キーボードから入力を取り扱うクラスとメソッド。
    public static int year1(String msg) throws IOException {
        
        //メッセージ表示
        System.out.println(msg);
        
        int ansint =0;
        String ansstr =null;
        
        //必要なクラスをインスタンス化。
        ketasuu keta = new ketasuu();
        
        //入力処理
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
        String brr = br.readLine();
        //数字変換処理
        int tosi = Integer.parseInt(brr);
            ansint = tosi;
        }
        catch (IOException e) {
            System.out.println("入力デバイスを確認して下さい。");
            karennda.sts = -9;
            ansstr = "errcode09：デバイスエラー";
            return ansint;
        }
        catch (NumberFormatException e) {
            System.out.println("英字や小数点は付いた数字は受け付けておりません。整数で入力して下さい。(1873～)");
//            return String.toString("errng");
            karennda.sts = 9;
            ansstr = "errcode01：入力値エラー";
            return ansint;
        }
        
        //桁数確認処理
        int ks = keta.ketasuu(ansint);
        
        //入力値が正常値がどうかの判断
        if (ks >4) {
            System.out.println("5桁以上の数字は対応しておりません。4桁の数字を入力して下さい。(1873～)");
            karennda.sts = 9;
        } else if (ansint <1872) {
            System.out.println("1872以下の数字は入力出来ません。1873以上の数字を入力して下さい。(4桁まで。)");
            karennda.sts = 9;
        } else if (ansint >=1873) {
            karennda.sts = 0;
        } else {
            //現在は処理の設定していない。
        }
        
        //デバッグ用表示処理
//        System.out.println(ansint);
        
    return ansint;
    }
}
class uruucheck {       //うるう年の確認クラス
    public static boolean uruck(int uru) {
        
        //変数定義
        boolean uruu;
        
        if (uru % 4 == 0) {
            if (uru % 100 == 0) {
                if (uru % 400 != 0) {
                    uruu = false;    //うるう年の例外
                } else {
                    uruu = true;    //うるう年(400年毎)
                }
            } else {
                uruu = true;    //うるう年(100年毎)
            }
        } else {
            uruu = false;    //うるう年以外(平年：4年毎)
        }
        return uruu;
    }
}
//class uruuhandan{
//    public static boolean uruhdn(){
    
//    String w1 = "うるう年かどうかを判定します。数字を入力して下さい。(1873～)";
    
//    int uruudishi;
//    int uck = 0;
    
    //西暦入力処理
//    nyuuryoku nryk = new nyuuryoku();
//    int uck = nryk.year1();

//    if (nryk.year1(w1) == 0) {
//        System.out.println("もう一度入力し直して下さい。");
//    }
    
//    uck = nn1;

        
    //うるう年の判断
//    uruucheck ck1 = new uruucheck();
//    boolean uruudishi = ck1.uruck(uck);

    
    //変数に代入
//    uck = uruudishi;
//    }
//}
//class aisatubun {
//    public static String aisatu(int wrd) {
        
//        String aaa ="";
        
//        if (wrd==1){
//                aaa = "ご利用有難う御座います。此方は日付・曜日検索システムです。";
//                bbb = "それでは、早速開始しましょう！";
//        } else if (wrd==2) {
//                aaa = "数字以外は受け付けておりません。再度入力して下さい。";
//        } else if (wrd==3) {
//                aaa = "再度入力して下さい。数字以外は受け付けておりません。";
//        } else {
//        }
//        return aaa;
//    } 
//}
class aisatubun {        //各処理のメッセージ文格納クラス
    public static void aisatu(int wrd) {
        
        kaigyou kaigyou1 = new kaigyou();
        
        if (wrd==1){
            System.out.println("ご利用有難う御座います。此方は日付・曜日検索システムです。");
            System.out.println("それでは、早速開始しましょう！");
        } else if (wrd==2) {
            System.out.println("入力時に不備が有りました。再度入力して下さい。");
        } else if (wrd==3) {
            System.out.println("複数回入力を間違えたか、又は、一定回数以上処理を繰り返した為、処理を終了します。" + kaigyou1.kaigyou() + "お手数ですが、最初からやり直して下さい。");
        } else if (wrd==4) {
            System.out.println("日付・曜日検索システムを終了しますか? →'Y'、'N' ");
//        } else if (wrd==5) {
//            System.out.println("");
        } else if (wrd==9) {
            System.out.println("入力中にエラーが発生しました。" + kaigyou1.kaigyou() + "お手数ですが、最初からやり直して下さい。");
        } else if (wrd==10) {
            System.out.println("入力を確認しました。");
        } else if (wrd==-1) {
            System.out.println("処理中にエラーが発生しました。" + kaigyou1.kaigyou() + "処理を中止致します。スタッフをお呼び下さい。");
        } else {
        }
    } 
}
class ketasuu {         //桁数確認のクラス
    static int ketasuu(int suu) {
    double dobsuu = (double)suu;
    double jou =0;
    
    while (jou <=4) {
        double keta = Math.pow(10,jou);
            
        if (dobsuu<keta) {
            break;
        }
        jou++;
    }

    int jouint = (int)jou;
    
    //デバッグ用表示処理
//    System.out.println(jouint);
    
    return jouint;
    }
//    keta = keta +1 ;
}
class nyuuryokubase {          //入力の基本クラス
    //変数設定
    static int nyrksts = 0;
    static String nyrkmsg = "";
    static String nryk1;
    static String ng = "ng";
    
    static String msg1="";
    
    public static String nryk() throws IOException {
        
        //メッセージ表示処理
        if (msg1.isEmpty()){
            //何もしない。
        } else {
            System.out.println(msg1);      //メッセージを表示する。
        }
        
        try{
        //入力処理
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        nryk1 = br1.readLine();
        }
        catch (IOException e) {
            System.out.println("入力デバイスを確認して下さい。");
            nyrksts = -9;
            nyrkmsg = "errcode09：デバイスエラー";
            msg1="";      //メッセージ初期化
            return ng;
        }
        
        msg1="";      //メッセージ初期化
        
        //入力値処理
        return nryk1;
    }
}
class mdck {
    
    //変数定義
    private static int mdhd =0;               //このクラスのステータスコード。
    protected static int monthnum;      //正常値の'月'の数字(検索値)
    protected static int daysnum;      //正常値の'日'の数字(検索値)
    protected static int mmddck;      //入力された月日の数字。
    private static int gtmt;      //各月の日数。
    
    
    public static int mdck1(String mmdd){
    
    //必要なメソッド_インスタンス化
    kaigyou kaigyou2 = new kaigyou();
    aisatubun aisatu3 = new aisatubun();
    nyuuryokubase nyrk2 = new nyuuryokubase();
//    shuuryou shry1 = new shuuryou();
        
    //うるう年の判断結果反映
        
    try{
        mmddck = Integer.parseInt(mmdd);
        
//        System.out.println(mmddck);
        
        //'0'が入力されたら、その時点で処理を終了させる。
        if (mmddck ==0) {
            mdhd =9;
            return mdhd;
        }
        
        //メインの処理
        if (mmdd.length() ==4) {
            mdhd = fourdecimal(karennda.uruudays,mmdd);
//          break;
        } else if (mmdd.length() <=2){
            
            if (mmddck<=12) {
                System.out.println("入力された数字は" + mmddck + "となります。" + kaigyou2.kaigyou() + "今回入力した数字は'月'でしょうか? それとも'日'でしょうか?  '月'(T)'、'日'(H) ");
                
                try{
                    String a1 = nyrk2.nryk();
                
                if (a1.equals("T") || a1.equals("t")) {
                    System.out.println("入力された数字は'月'として登録しました。");
                    monthnum = mmddck;
                    mdhd = 1;
                } else if (a1.equals("H") || a1.equals("h")) {
                    System.out.println("入力された数字は'日'として登録しました。");
                    daysnum = mmddck;
                    mdhd = 2;
                } else {
                    System.out.println("入力された数字の登録をキャンセルしました。もう一度入力し直して下さい。");
                    mdhd = 9;
                }
                
                }catch(IOException e){
                    shuuryou.ends(9);
                }
            } else if (mmddck>12 && mmddck<32) {
                System.out.println("入力された数字は" + mmddck + "となります。今回入力した数字は'日'として登録しますか? →'Y'、'N' ");
                
                try{
                String a2 = nyrk2.nryk();
                
                if (a2.equals("Y") || a2.equals("y")) {
                    System.out.println("今回入力した数字は'日'として登録しました。" + kaigyou2.kaigyou() + "続いて'月'を入力して下さい。");
                    daysnum = mmddck;
                    mdhd = 2;
                } else if (a2.equals("N") || a2.equals("n")) {
                    System.out.println("入力された数字の登録をキャンセルしました。もう一度入力し直して下さい。");
                    mdhd = 9;
                } else {
                    System.out.println("入力された数字の登録をキャンセルしました。もう一度入力し直して下さい。");
                    mdhd = 9;
                }
                }catch(IOException e){
                    shuuryou.ends(9);
                }
                
            } else if (mmddck>=32) {
                System.out.println("不正な数字が入力されました。もう一度入力し直して下さい。(～31まで。)");
                mdhd = 9;
            } else {
                aisatu3.aisatu(2);   //入力値不正
                mdhd = 9;
            }
        } else if (mmdd.length() ==3) {
            System.out.println("3桁の数字の場合、月日の判断が出来ない為、入力を受け付けておりません。もう一度入力し直して下さい。");
            mdhd = 9;
        } else if (mmdd.length() >4) {
            System.out.println("4桁か2桁で入力して下さい。もう一度入力し直して下さい。");        
            mdhd = 9;     //9
        } else {
            //ここには流れないはず。一応。
            mdhd = -1;
            //エラー処理に移行。
        }
    }catch(NumberFormatException e) {
        System.out.println("英字や月日の桁数で不正な数字を入力した場合、登録出来ません。");
        aisatu3.aisatu(2);
        mdhd = 9;
    }
    
    //各月の日数計算処理
    if (mdhd == 1) {
    gtmt = gtmt(karennda.uruudays,monthnum);
    }
    
    //再度入力処理
    if (mdhd == 1) {
        System.out.println("'日'の数字を入力して下さい。");
        
        try{
        String a3 = nyrk2.nryk();
        
        if (a3.length() ==2) {
            try{
                int a3int =Integer.parseInt(a3);
            
            if (a3int>=1 && a3int<=gtmt) {
                System.out.println("入力された数字は" + a3 + "となります。今回入力した数字は'日'として登録しますか? →'Y'、'N' ");
                
                try{
                String a4 = nyrk2.nryk();
                
                if (a4.equals("Y") || a4.equals("y")) {
                    System.out.println("入力された数字は'日'として登録しました。");
                    daysnum = a3int;
                    mdhd = 0;
                } else if (a4.equals("N") || a4.equals("n")) {
                    System.out.println("入力された数字の登録をキャンセルしました。もう一度入力し直して下さい。");
                    mdhd = 9;
                } else {
                    System.out.println("入力された数字の登録をキャンセルしました。もう一度入力し直して下さい。");
                    mdhd = 9;
                }
                }catch(IOException e) {
                    System.out.println("もう一度入力し直して下さい。");
                    mdhd = 9;                    
                }
            } else if (a3int>gtmt) {
                System.out.println("'日'の有効数字(2桁、最大31まで。)のみ入力可能です。もう一度入力し直して下さい。");
                mdhd = 9;                
            } else {
                System.out.println("'日'の有効数字(2桁、最大31まで。)のみ入力可能です。もう一度入力し直して下さい。");
                mdhd = 9;  
            }
            }catch(NumberFormatException e) {
                System.out.println("数字のみの入力となります。もう一度入力し直して下さい。");
                mdhd = 9;                
            }
        } else {
            System.out.println("'日'の有効数字(2桁、最大31まで。)のみ入力可能です。もう一度入力し直して下さい。");
            mdhd = 9;             
        }
        }catch(IOException e) {
            System.out.println("もう一度入力し直して下さい。");
            mdhd = 9;                
        }
    } else if (mdhd == 2) {
        System.out.println("'月'の数字を入力して下さい。");   
        
        try{
            String a5 = nyrk2.nryk();
            
            try{
                int a5int =Integer.parseInt(a5);
            
                if (a5int >=1 && a5int <=12) {
                    System.out.println("入力された数字は'月'として登録しました。");
                    monthnum = a5int;
                    mdhd = 0;
                } else if (a5int >12) {
                    System.out.println("入力された数字が不正な値です。もう一度入力し直して下さい。");
                    mdhd = 9;   
                } else if (a5int ==0) {      //入力された時点で'0'は弾かれる様にしてあるので、ここは万が一の処理となる。
                    System.out.println("'月'に'0'を設定する事はできません。もう一度入力し直して下さい。");
                    mdhd = 9;                     
                }
            }catch(NumberFormatException e) {
                System.out.println("数字のみの入力となります。もう一度入力し直して下さい。");
                mdhd = 9;                
            }
        }catch(IOException e) {
                System.out.println("もう一度入力し直して下さい。");
                mdhd = 9;
        }
    } else if (mdhd == 9){
        aisatu3.aisatu(2);
    } else if (mdhd == 0) {
        aisatu3.aisatu(10);
    } else if (mdhd < 0){
        aisatu3.aisatu(-1);
        for(int i=0;i <15;i++) {
            System.out.print(kaigyou2.kaigyou());
        
            switch(i) {
            case 5:
                System.out.print(" ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
                break;
            case 6:
                System.out.print("｜スタッフをお呼び下さい。｜");
                break;
            case 7:
                System.out.print(" ＿＿＿＿＿＿＿＿＿＿＿＿＿ ");
            }
        }
    }
    
    //結果返却
    return mdhd;
    
    }
    public static int gtmt(int y1,int tuki) {          //各月の日にち判断。
        
//    mdck mdck1 = new mdck();
    
        if (tuki == 2){
            gtmt = 28 + y1;
        } else if (tuki == 4 | tuki == 6 | tuki == 9 | tuki == 11) {
            gtmt = 30;
        } else {
            gtmt = 31;
        }
    return gtmt;
    }
    
    public static int fourdecimal(int uryr,String md) {
    
    aisatubun aisatu4 = new aisatubun();
//    kaigyou kaigyou3 = new kaigyou();
    nyuuryokubase nyrk3 = new nyuuryokubase();
    
//    System.out.println(mdhd);
        
    int mdint = Integer.parseInt(md);
    int k =0;
            
    if (mdint >1231) {
        aisatu4.aisatu(2);
        mdhd = 9;
    } else if (mdint <= 1231) {
        monthnum = Integer.parseInt(md.substring(0,2));
         daysnum = Integer.parseInt(md.substring(2));
            
        k =1;
    }
    if (k>0) {
        
        if (monthnum >0 && monthnum <=12) {
            
            System.out.println("月の確認が完了しました。");
            int gtmt1 = gtmt(uryr,monthnum);
            
            if (daysnum >0 && daysnum <=gtmt1) {
                System.out.println("日の確認が完了しました。");
                
                mdhd = 0;
                
            } else {
                System.out.println("'日'の数値が不正な値です。後方の2文字が'xx01～xx31'(月によって異なる。)の間の整数を入力して下さい。");
                mdhd = 9;
            }
        } else {
            System.out.println("'月'の数値が不正な値です。先頭の2文字が'01xx～12xx'の間の整数を入力して下さい。");
            mdhd = 9;
        }
    } else {
        mdhd = 9;
    }
    
    //確認処理
    if (mdhd ==0) {
//        System.out.println("検索したい日付は" +monthnum+ "月" +daysnum+ "日ですね?" +kaigyou3.kaigyou()+ "宜しければ'Y'を入力して下さい。中止する場合は'N'を押して下さい。 →'Y'、'N'");
        System.out.println("検索したい日付は" +monthnum+ "月" +daysnum+ "日ですね?");
        
        nyrk3.msg1= "宜しければ'Y'を入力して下さい。中止する場合は'N'を押して下さい。 →'Y'、'N'";
        try{
        String a6 = nyrk3.nryk();
    
            if (a6.equals("Y") || a6.equals("y")) {
                System.out.println("入力された数字を検索条件に登録しました。");
                mdhd = 0;
            } else if (a6.equals("N") || a6.equals("n")) {
                System.out.println("入力された数字の登録をキャンセルしました。もう一度入力し直して下さい。");
                mdhd = 9;
            } else {
                System.out.println("不正な値が入力されました。もう一度最初から入力し直して下さい。");
                mdhd = 9;
            }
        }catch(IOException e){
        shuuryou.ends(9);
        }
    }
    return mdhd;
    } 
}
class keisann {
    private static int ans;
    private static int ks[][] = new int[13][32];
    static int uruu;
    static int getumatu1;
//    boolean uruks = karennda.main.urubool;
        
    private static void hirthnti() {
        
        //メソッド呼出し
        mdck mdck2 = new mdck();
//        getumatu1 = mdck2.gtmt(uruu,);
        
//        int a =0;
//        int b = 0;
        int c =1;
    
    for(int a=1;a <=12; a++) {
        for(int b=1;b <=mdck2.gtmt(uruu,a); b++){
//            System.out.println(mdck2.gtmt(uruu,a));
            ks[a][b] = c;
            c++;
//        System.out.println("ksは"+ks[a][b]+"、aは" + a+ "、bは"+b +"、cは"+ c);
        
//        b++;
        }
//        a++;
    }
        System.out.println("差分配列の作成が完了致しました。");
    }
    
    public static int ksn(int mn,int dy){
        hirthnti();
        
        ans = ks[mn][dy];
        
        return ans;
    }
    public static void showks(int aa,int bb) {
        System.out.println(aa+"月"+bb+"日の日数は、今年の1月1日から"+(ks[aa][bb] -1)+"日後です。");
    }
    public static int nissuuksn(int mn1,int dy1,int i) {
        int hiniti=ksn(mn1,dy1);
        
        if (i == 1) {
            return hiniti;
        } else if (i == 2) {
            if (uruu == 0) {
                return 366- hiniti ;
            } else if (uruu == 1) {
                if (hiniti<=60){
                    return 367- hiniti ;
                } else if  (hiniti>60){
                    return 366- hiniti ;
                }
            } else {
                System.out.println("うるう年の係数が間違っています。");
                return 400;
            }
        } else {
            System.out.println("計算の指定(年始から、年末まで)の係数が間違っています。");
            return 401;
        }
    System.out.println("例外な値が係数として指定されました。");
    return 409;
    }
}

class shuuryou {          //システム終了のクラスとメソッド
    
    //変数定義箇所
    int st = 0;
//    static String ans;
//    static String yn = "システムの終了処理に入ります。";
//    String y = "Y";
//    String n = "N";
    
//        nyuuryokubase nb = new nyuuryokubase();
//        nb.msg1 = yn;
//        String ans1 = nb.nryk(yn);
//        String ans1 = nb1;
        
        //回答の配列
//        String y[]= {"Y","y"};
//        String n[]= {"N","n"};
    
//    public static int yn() {
        
//    ans = nb.nryk(yn);
    
    public static void ends(int edst) {
        if (edst == 9) {
//    if (ans.equals(y)) {
        System.out.println("システムを終了します。");
            int ynst = 0;
            karennda.sts = ynst;
            System.exit(0); //システムの終了。
//        } else if (ans2.equals("N")) {
//        System.out.println("システムを終了せずに処理を続行します。");
//            int ynst = 1;
//    }
        } else {
        }
    }
//    st = ynst;
    
//    return st;
//    }
// }
}