/*    */ package init.tech;
/*    */ 
/*    */ import game.boosting.BoostSpec;
/*    */ import init.sprite.UI.UI;
/*    */ import init.value.Lock;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ 
/*    */ final class TechIcon {
/*    */   public static SPRITE icon(final TECH t) {
/* 12 */     if (t.lockers.all().size() == 1)
/* 13 */       return ((Lock)t.lockers.all().get(0)).lockable.icon.resized(64); 
/* 14 */     if (t.lockers.all().size() == 2 && ((Lock)t.lockers.all().get(0)).lockable.icon == ((Lock)t.lockers.all().get(1)).lockable.icon)
/* 15 */       return ((Lock)t.lockers.all().get(0)).lockable.icon.resized(64); 
/* 16 */     if (t.lockers.all().size() > 1) {
/* 17 */       return (SPRITE)new SPRITE.Imp(64)
/*    */         {
/*    */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */           {
/* 21 */             int w = (X2 - X1) / 2;
/* 22 */             int h = (Y2 - Y1) / 2;
/* 23 */             for (int i = 0; i < t.lockers.all().size() && i < 4; i++) {
/* 24 */               int dx = i % 2 * w;
/* 25 */               int dy = i / 2 * h;
/* 26 */               ((Lock)t.lockers.all().get(i)).lockable.icon.render(r, X1 + dx, X1 + w + dx, Y1 + dy, Y1 + h + dy);
/*    */             } 
/*    */           }
/*    */         };
/*    */     }
/*    */     
/* 32 */     if (t.boosters.all().size() == 1) {
/* 33 */       SPRITE.Scaled scaled = new SPRITE.Scaled(((BoostSpec)t.boosters.all().get(0)).boostable.nativeIcon, 1.5D);
/* 34 */       return get((SPRITE)scaled, (UI.icons()).s.plus2.scaled(2.0D).createColored((GCOLOR.T()).IGREAT));
/*    */     } 
/* 36 */     if (t.boosters.all().size() > 1) {
/* 37 */       SPRITE.Imp imp = new SPRITE.Imp(64)
/*    */         {
/*    */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */           {
/* 41 */             int w = (X2 - X1) / 2;
/* 42 */             int h = (Y2 - Y1) / 2;
/* 43 */             for (int i = 0; i < t.boosters.all().size() && i < 4; i++) {
/* 44 */               int dx = i % 2 * w;
/* 45 */               int dy = i / 2 * h;
/* 46 */               ((BoostSpec)t.boosters.all().get(i)).boostable.icon.render(r, X1 + dx, X1 + w + dx, Y1 + dy, Y1 + h + dy);
/*    */             } 
/*    */           }
/*    */         };
/*    */       
/* 51 */       return get((SPRITE)imp, (UI.icons()).s.plus2.scaled(2.0D).createColored((GCOLOR.T()).IGREAT));
/*    */     } 
/*    */     
/* 54 */     return (SPRITE)(UI.icons()).s.cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   private static SPRITE get(final SPRITE bg, final SPRITE fg) {
/* 59 */     return (SPRITE)new SPRITE.Imp(64)
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */         {
/* 63 */           bg.renderC(r, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2);
/* 64 */           fg.render(r, X2 - fg.width() + 8, Y1 - 8);
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\tech\TechIcon.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */