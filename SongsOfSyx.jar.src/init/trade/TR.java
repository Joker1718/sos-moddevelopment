/*    */ package init.trade;
/*    */ 
/*    */ import init.INIT;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import init.sprite.UI.Icon;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.RMAPS;
/*    */ 
/*    */ public class TR {
/* 18 */   private final ArrayListGrower<TRADABLE> all = new ArrayListGrower();
/* 19 */   private final ArrayListGrower<TRADABLEO<RESOURCE>> res = new ArrayListGrower();
/* 20 */   private final ArrayListGrower<TRADABLEO<Race>> slaves = new ArrayListGrower();
/*    */   private final RMAPS<TRADABLE> map;
/*    */   private static TR s;
/*    */   
/*    */   public TR(INIT init) {
/* 25 */     s = this;
/* 26 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 27 */       String key = "RES_" + (r.key.startsWith("_") ? r.key.substring(1) : r.key);
/* 28 */       int index = this.all.size();
/* 29 */       Icon icon = r.icon();
/* 30 */       TRADABLEO<RESOURCE> tt = new TRADABLEO<>(r, key, index, (INFO)r, (SPRITE)icon);
/* 31 */       this.res.add(tt);
/* 32 */       this.all.add(tt);
/*    */     } 
/*    */ 
/*    */     
/* 36 */     for (Race r : RACES.all()) {
/* 37 */       String key = "SLAVE_" + r.key;
/* 38 */       int index = this.all.size();
/* 39 */       SPRITE.Imp imp = new SPRITE.Imp(24, 24)
/*    */         {
/*    */           public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2)
/*    */           {
/* 43 */             (r.appearance()).icon.render(rr, X1, X2, Y1, Y2);
/* 44 */             (UI.icons()).s.slave.render(rr, X2 - 16, X2, Y2 - 16, Y2);
/*    */           }
/*    */         };
/*    */ 
/*    */       
/* 49 */       TRADABLEO<Race> tt = new TRADABLEO<>(r, key, index, (INFO)r.info, (SPRITE)imp);
/* 50 */       this.slaves.add(tt);
/* 51 */       this.all.add(tt);
/*    */     } 
/*    */     
/* 54 */     this.map = new RMAPS("TRADABLE", (LIST)this.all);
/*    */   }
/*    */   
/*    */   public static LIST<TRADABLE> ALL() {
/* 58 */     return (LIST<TRADABLE>)s.all;
/*    */   }
/*    */   
/*    */   public static LIST<TRADABLEO<RESOURCE>> RES() {
/* 62 */     return (LIST<TRADABLEO<RESOURCE>>)s.res;
/*    */   }
/*    */   
/*    */   public static LIST<TRADABLEO<Race>> SLAVES() {
/* 66 */     return (LIST<TRADABLEO<Race>>)s.slaves;
/*    */   }
/*    */   
/*    */   public static RMAPS<TRADABLE> MAP() {
/* 70 */     return s.map;
/*    */   }
/*    */   
/*    */   public static TRADABLEO<RESOURCE> get(RESOURCE res) {
/* 74 */     return (TRADABLEO<RESOURCE>)s.res.get(res.index());
/*    */   }
/*    */   
/*    */   public static TRADABLEO<Race> get(Race res) {
/* 78 */     return (TRADABLEO<Race>)s.slaves.get(res.index());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\trade\TR.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */