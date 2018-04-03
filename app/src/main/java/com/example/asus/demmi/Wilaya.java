package com.example.asus.demmi;

/**
 * Created by asus on 20/03/2018.
 */

public class Wilaya {


    public Wilaya() {

    }

    public static String valueOf(Wilayas wilaya) {

        String outPut="";

        switch (wilaya) {
            case ADRAR:
                outPut = "أدرار";
                break;
            case CHLEF:
                outPut = "الشلف";
                break;
            case LAGHOUAT:
                outPut = "الأغواط";
                break;
            case OUM_ELBOUAGHI:
                outPut = "أم البواقي";
                break;
            case BATNA:
                outPut = "باتنة";
                break;
            case BEJAYA:
                outPut = "بجاية";
                break;
            case BISKRA:
                outPut = "بسكرة";
                break;
            case BECHAR:
                outPut = "بشار";
                break;
            case BLIDA:
                outPut = "البليدة";
                break;
            case BOUIRA:
                outPut = "بويرة";
                break;
            case TAMANRASSET:
                outPut = "تمنراست";
                break;
            case TEBESSA:
                outPut = "تبسة";
                break;
            case TLEMCEN:
                outPut = "تلمسان";
                break;
            case TIARET:
                outPut = "تيارت";
                break;
            case TIZI_OUZOU:
                outPut = "تيزي وزو";
                break;
            case ALGER:
                outPut = "الجزائر";
                break;
            case DJELFA:
                outPut = "الجلفة";
                break;
            case JIJEL:
                outPut = "جيجل";
                break;
            case SETIF:
                outPut = "سطيف";
                break;
            case SAIDA:
                outPut = "سعيدة";
                break;
            case SKIKDA:
                outPut = "سكيكدة";
                break;
            case SIDI_BELABBES:
                outPut = "سيدي بلعباس";
                break;
            case ANNABA:
                outPut = "عنابة";
                break;
            case GUELMA:
                outPut = "قالمة";
                break;
            case CONSTANTINE:
                outPut = "قسنطينة";
                break;
            case MEDEA:
                outPut = "مدية";
                break;
            case MOSTAGANEM:
                outPut = "مستغانم";
                break;
            case MSILA:
                outPut = "مسيلة";
                break;
            case MASCARA:
                outPut = "معسكر";
                break;
            case OUARGLA:
                outPut = "ورقلة";
                break;
            case ORAN:
                outPut = "وهران";
                break;
            case EL_BAYADH:
                outPut = "البيض";
                break;
            case ILLIZI:
                outPut = "إليزي";
                break;
            case BORDJ_BOUARRERIDJ:
                outPut = "برج بوعريريج";
                break;
            case BOUMERDES:
                outPut = "بومرداس";
                break;
            case EL_TAREF:
                outPut = "الطارف";
                break;
            case TINDOUF:
                outPut = "تيندوف";
                break;
            case TISSEMSILT:
                outPut = "تيسمسيلت";
                break;
            case EL_OUED:
                outPut = "الوادي";
                break;
            case KHENCHELA:
                outPut = "خنشلة";
                break;
            case SOUKAHRAS:
                outPut = "سوق أهراس";
                break;
            case TIPAZA:
                outPut = "تيبازة";
                break;
            case MILA:
                outPut = "ميلة";
                break;
            case AIN_DEFLA:
                outPut = "عين الدفلة";
                break;
            case NAAMA:
                outPut = "النعامة";
                break;
            case AIN_TEMOUCHENT:
                outPut = "عين تيموشنت";
                break;
            case GHARDAIA:
                outPut = "غرداية";
                break;
            case RELIZANE:
                outPut = "غيليزان";
                break;
        }
        return outPut;
    }
}
