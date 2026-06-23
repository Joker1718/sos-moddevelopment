/*    */ package init.type;
/*    */ 
/*    */ import game.boosting.BOOSTING;
/*    */ import game.boosting.Boostable;
/*    */ import game.boosting.BoostableCat;
/*    */ import init.paths.PATHS;
/*    */ import init.sprite.UI.Icons;
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.service.StatService;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.keymap.MAPPED;
/*    */ import util.text.D;
/*    */ 
/*    */ public class NEED
/*    */   implements MAPPED {
/* 22 */   private static CharSequence ¤¤rateD = "The rate at which the need of {0} increases daily.";
/*    */   static {
/* 24 */     D.ts(NEED.class);
/*    */   }
/*    */   public final CharSequence nameNeed;
/*    */   public final String key;
/*    */   public final double event;
/*    */   public final Boostable rate;
/*    */   private final int index;
/*    */   public final boolean basic;
/*    */   
/*    */   NEED(String key, PATHS.ResFolder f, LISTE<NEED> all, BoostableCat cat, SPRITE icon, boolean basic) {
/*    */     Icons.S.IconS iconS1;
/* 35 */     this.index = all.add(this);
/* 36 */     this.key = key;
/* 37 */     Json jt = new Json(f.text.gets(key));
/* 38 */     Json jd = new Json(f.init.gets(key));
/* 39 */     this.nameNeed = jt.text("NAME_NEED");
/* 40 */     this.basic = basic;
/* 41 */     this.event = jd.dTry("EVENT", 0.0D, 10000.0D, 0.0D);
/* 42 */     if (icon == null)
/* 43 */       iconS1 = (UI.icons()).s.clock; 
/* 44 */     final Icons.S.IconS ii = iconS1;
/* 45 */     SPRITE.Imp imp = new SPRITE.Imp(16)
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */         {
/* 49 */           LIST<StatService> g = STATS.SERVICE().perNeed(NEED.this);
/* 50 */           if (g != null && g.size() > 0) {
/* 51 */             ((StatService)g.get(0)).icon.render(r, X1, X2, Y1, Y2);
/*    */           } else {
/* 53 */             ii.render(r, X1, X2, Y1, Y2);
/*    */           } 
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 59 */     this.rate = BOOSTING.push(key, jd.d("RATE"), jt.text("NAME_RATE"), String.valueOf(Str.TMP.clear().add(¤¤rateD).insert(0, this.nameNeed)), (SPRITE)imp, cat);
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 64 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 69 */     return this.key;
/*    */   }
/*    */   
/*    */   public LIST<StatService> sGroup() {
/* 73 */     return STATS.SERVICE().perNeed(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 78 */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\NEED.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */