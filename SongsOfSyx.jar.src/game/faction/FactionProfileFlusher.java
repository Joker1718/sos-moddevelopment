/*    */ package game.faction;
/*    */ 
/*    */ import game.faction.player.Player;
/*    */ import game.faction.player.PlayerColors;
/*    */ import init.paths.PATHS;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.file.JsonE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FactionProfileFlusher
/*    */ {
/*    */   private static final String name = "FACTION";
/*    */   
/*    */   public static void flush(Player p) {
/*    */     try {
/* 20 */       JsonE j = new JsonE();
/* 21 */       j.addString("RULER_NAME", String.valueOf(p.rulerName()));
/* 22 */       j.addString("FACTION_NAME", String.valueOf(p.name));
/* 23 */       color(j, (COLOR)p.banner().colorBG(), "COLOR_BANNER_BACKGROUND");
/* 24 */       color(j, (COLOR)p.banner().colorFG(), "COLOR_BANNER_FOREGROUND");
/* 25 */       color(j, (COLOR)p.banner().colorBorder(), "COLOR_BANNER_BORDER");
/* 26 */       color(j, (COLOR)p.banner().colorPole(), "COLOR_BANNER_POLE");
/*    */       
/* 28 */       JsonE cols = new JsonE();
/*    */       
/* 30 */       for (String k : PlayerColors.cats().keys()) {
/* 31 */         for (PlayerColors.PlayerColor c : PlayerColors.cats().get(k)) {
/* 32 */           color(cols, (COLOR)c.color, c.cat + "_" + c.cat);
/*    */         }
/*    */       } 
/* 35 */       String s = "";
/* 36 */       for (int i = 0; i < 144; i++) {
/* 37 */         s = s + s;
/*    */       }
/* 39 */       j.add("BANNER_DATA", s);
/*    */       
/* 41 */       j.add("COLORS", cols);
/*    */       
/* 43 */       if (!(PATHS.local()).PROFILE.exists("FACTION"))
/* 44 */         (PATHS.local()).PROFILE.create("FACTION"); 
/* 45 */       j.save((PATHS.local()).PROFILE.get("FACTION"));
/* 46 */     } catch (Exception e) {
/* 47 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static void color(JsonE j, COLOR c, String key) {
/* 54 */     String v = "" + 2 * (c.red() & 0xFF) + "_" + 2 * (c.red() & 0xFF) + "_" + 2 * (c.green() & 0xFF);
/* 55 */     j.add(key, v);
/*    */   }
/*    */   
/*    */   public static boolean canLoad(Player p) {
/* 59 */     return (PATHS.local()).PROFILE.exists("FACTION");
/*    */   }
/*    */ 
/*    */   
/*    */   public static void load(Player p) {
/* 64 */     if (!(PATHS.local()).PROFILE.exists("FACTION"))
/*    */       return; 
/*    */     try {
/* 67 */       Json json = new Json((PATHS.local()).PROFILE.gets("FACTION"));
/* 68 */       p.rulerName.clear().add(json.text("RULER_NAME"));
/* 69 */       p.name.clear().add(json.text("FACTION_NAME"));
/* 70 */       p.banner().colorBG().set((COLOR)new ColorImp(json, "COLOR_BANNER_BACKGROUND"));
/* 71 */       p.banner().colorFG().set((COLOR)new ColorImp(json, "COLOR_BANNER_FOREGROUND"));
/* 72 */       p.banner().colorBorder().set((COLOR)new ColorImp(json, "COLOR_BANNER_BORDER"));
/* 73 */       p.banner().colorPole().set((COLOR)new ColorImp(json, "COLOR_BANNER_POLE"));
/*    */ 
/*    */ 
/*    */       
/* 77 */       String s = json.value("BANNER_DATA");
/* 78 */       for (int i = 0; i < s.length(); i++) {
/* 79 */         (p.banner()).sprite.set(i, (s.charAt(i) == '1'));
/*    */       }
/*    */       
/* 82 */       if (json.has("COLORS")) {
/* 83 */         json = json.json("COLORS");
/* 84 */         for (String k : PlayerColors.cats().keys()) {
/* 85 */           for (PlayerColors.PlayerColor c : PlayerColors.cats().get(k)) {
/* 86 */             String kk = c.cat + "_" + c.cat;
/* 87 */             if (json.has(kk)) {
/* 88 */               c.color.set((COLOR)new ColorImp(json, kk));
/*    */             }
/*    */           }
/*    */         
/*    */         } 
/*    */       } 
/* 94 */     } catch (Exception e) {
/* 95 */       e.printStackTrace(System.out);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FactionProfileFlusher.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */