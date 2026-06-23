/*    */ package game.faction;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import init.sprite.BitmapSprite;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.Bitmap2D;
/*    */ import snake2d.util.sets.LIST;
/*    */ import world.region.RD;
/*    */ import world.region.pop.RDRace;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Initer
/*    */ {
/*    */   Initer(LIST<Faction> all) {
/* 20 */     setColors(all);
/*    */     
/* 22 */     RDRace race = RD.RACE(FACTIONS.player().race());
/* 23 */     (FACTIONS.player()).name.clear().add("Jakaton");
/* 24 */     if (race != null) {
/* 25 */       (FACTIONS.player()).name.clear().add(race.names.fNames.next());
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 31 */     Bitmap2D[] datas = BitmapSprite.read(PATHS.SPRITE().getFolder("ui").get("FactionBanners"));
/*    */     
/* 33 */     for (int i = 0; i < datas.length; i++) {
/* 34 */       int i2 = RND.rInt(datas.length);
/* 35 */       Bitmap2D old = datas[i];
/* 36 */       datas[i] = datas[i2];
/* 37 */       datas[i2] = old;
/*    */     } 
/*    */     
/* 40 */     int ki = 0;
/* 41 */     for (Faction f : all) {
/* 42 */       (f.banner()).sprite.paint(datas[ki++]);
/* 43 */       ki %= datas.length;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void setColors(LIST<Faction> all) {
/* 53 */     ArrayList<ColorImp> cols = new ArrayList((Iterable)ColorImp.cols(new Json((PATHS.WORLD()).init.getFolder("config").gets("Faction")), "COLORS")); int i;
/* 54 */     for (i = 0; i < cols.size(); i++) {
/* 55 */       cols.swap(i, RND.rInt(cols.size()));
/*    */     }
/* 57 */     i = 0;
/* 58 */     for (Faction f : all) {
/*    */       ColorImp colorImp;
/* 60 */       int kk = i / cols.size();
/* 61 */       COLOR col = (COLOR)cols.getC(i);
/* 62 */       if (kk > 0) {
/* 63 */         colorImp = (new ColorImp()).interpolate(col, (COLOR)cols.getC(i + kk), 0.5D);
/*    */       }
/*    */       
/* 66 */       f.banner().colorFG().set((COLOR)cols.getC(i + cols.size() / 2));
/* 67 */       f.banner().colorBG().set((COLOR)colorImp);
/* 68 */       i++;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\Initer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */