package Lekce_2022_09_20;

import java.util.ArrayList;

public class CeasarovaSifra {
    private static final char[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final ArrayList<Character> chars = new ArrayList<>();

    public static void main(String[] args) {
        initArrList();
        StringBuilder sifra = new StringBuilder("surjudprydql");
        StringBuilder novaSifra = new StringBuilder("pwba hv gl mzilwrol ybol gl qvmln gzplev yrov mrx wl sihgr hv gl evhol zov zmagl gl nvol kzi xvimbxs fhrhvp z eazwf lxzhvp famzor qhnv av gl qv khrhpl z kilglav qhnv hr kizor nrg khr sloxrxpf wzor qhnv glnf qnvml wzhvmpz wlpfw gl ybol yrov mrx ybol gl hovkv yva lxr z xl hv mlarxvp gbxv rmf nvol gl wez kzib xvslhr xvnf hv kir wlyiv efor nlsol irpzg mlarxpb zov kilglav gf gz wlyiz efov yboz ybob gf r mlarxpb givyzav qvhgv az nmlsl mvhgzob pwvkzp hgzg hv mz mrxs mvwzol gzplev ybob eizgpv z hozylfxpv z h xsfar gl yboz slovmpf gvkiev klgra pwba hv wl glsl wzhvmpz klizwmv lyfoz glgra lmz hv mvlyfoz zov ebpzhzoz hr mz gl ifpzeb kivhmvqr ivxvml zmr ifpzeb hr mvebpzhzoz zov qvmln hr qzp hv irpz koreoz wl wozmr ilafnvqgv nr lmz hr lehvn mvnlsoz koremlfg wl wozmr kilglav qvhgv korezg mvfnvoz z wozmv nvoz gzp nzorxpv av yb hr wl mrxs mvgivuroz apizgpz pwba hv wl glsl wzhvmpz klizwmv wzoz wlpfgzovoz hv az kfo wmv lw nznrmb azwmr mlsb p nznrmv mlav kivwmr kirxvna hv xvhglf girpizg mzpinroz z wezpizg ebhkzoz hkzg z qrhg fnvoz glgra smvw lw mzilavmr glnf hv fxrg mvnfhvoz kilgl gl wvozoz sliorev kl xvob ylar wvm z nbhorn av r e mlxr pwba hv mz mr mrpwl mvwrezo hkzoz hgvqmv hevwlnrgv qzpl ev wmv gzplev gl ybol kromv hgvmv");

        for (int i = 1; i < 42; i++) {
            System.out.println(i + " => " + posunPismenaVeSlove(sifra, i));
        }
    }

    private static char posunPismeno(char ch, int distance) {
        return characters[(chars.indexOf(ch)+distance) % characters.length];
    }

    private static String posunPismenaVeSlove(StringBuilder str, int distance) {
        for (int i = 0; i < str.length(); i++) {
            str.setCharAt(i, posunPismeno(str.charAt(i), distance));
        }

        return str.toString();
    }

    private static void initArrList() {
        for (char charr: characters) {
            chars.add(charr);
        }
    }
}
