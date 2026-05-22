package org.example;

import io.github.smile_ns.simplejson.SimpleJson;
import io.github.smile_ns.simplejson.SimpleJsonProperty;

import java.io.File;
import java.io.IOException;

//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
public class Main {
    static void main() throws IOException {
        /*
        SimpleJson ja_jp_original = new SimpleJson(new File("./input/ja_jp.json"));
        ja_jp_original.setSeparator("/");
        SimpleJson ja_jp = new SimpleJson(new File("./output/ja_jp.json"));
        ja_jp.setSeparator("/");
         */
        SimpleJson en_us_original = new SimpleJson(new File("./input/en_us.json"));
        en_us_original.setSeparator("/");
        SimpleJson en_us = new SimpleJson(new File("./output/en_us.json"));
        en_us.setSeparator("/");

        Object[] fragBlocks = new SimpleJson(new File("./fragment_block.json"))
                .getList("blocks").toArray();

        for (Object block : fragBlocks) {
            String blockName = block.toString();
            try {
                //String displayName = ja_jp_original.getString("block.minecraft."  + blockName);
                //ja_jp.put("block/jumbo_craft/" + blockName + "_fragment", displayName + "の破片");

                String displayName = en_us_original.getString("block.minecraft."  + blockName);
                en_us.put("block/jumbo_craft/" + blockName + "_fragment", displayName + " Fragment");
            } catch (NullPointerException e) {
                System.out.println("failed: " + blockName);
                throw e;
            }
        }

        //ja_jp.save();
        en_us.save();
    }
}
