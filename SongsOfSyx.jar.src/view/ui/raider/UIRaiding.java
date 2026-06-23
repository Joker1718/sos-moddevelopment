/*    */ package view.ui.raider;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.raiding.Raider;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import util.text.Dic;
/*    */ import view.ui.manage.IFullView;
/*    */ 
/*    */ public final class UIRaiding extends IFullView {
/* 14 */   public static CharSequence ¤¤name = "Raiders"; static boolean debug;
/*    */   
/*    */   static {
/* 17 */     D.ts(UIRaiding.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public UIRaiding() {
/* 23 */     super(Dic.¤¤Raiding, (SPRITE)(UI.icons()).l.rebel);
/*    */     
/* 25 */     this.section.body().setWidth(WIDTH);
/* 26 */     this.section.body().setHeight(1.0D);
/*    */     
/* 28 */     this.section.addRelBody(2, DIR.S, (RENDEROBJ)new Info());
/*    */     
/* 30 */     Current c = new Current(HEIGHT - this.section.getLastY2() - 8);
/* 31 */     List l = new List(c, HEIGHT - this.section.getLastY2() - 8);
/* 32 */     l.addRelBody(8, DIR.E, (RENDEROBJ)c);
/*    */     
/* 34 */     this.section.addRelBody(16, DIR.S, (RENDEROBJ)l);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void activate() {
/* 41 */     super.activate();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 46 */   private static int ci = -1;
/* 47 */   private static int vi = -1;
/*    */   
/*    */   static boolean statsVisible(Raider r) {
/* 50 */     if (r.defeated)
/* 51 */       return true; 
/* 52 */     if (r.raids > 0)
/* 53 */       return true; 
/* 54 */     if (debug)
/* 55 */       return true; 
/* 56 */     if (r.isScared())
/* 57 */       return true; 
/* 58 */     if (r.hasInterrest())
/* 59 */       return true; 
/* 60 */     if (ci != GAME.updateI()) {
/* 61 */       ci = GAME.updateI();
/* 62 */       for (Raider rr : GAME.raiders().ALL()) {
/* 63 */         if (!rr.defeated && !rr.isScared() && !rr.hasInterrest()) {
/* 64 */           vi = rr.bounty;
/*    */           break;
/*    */         } 
/*    */       } 
/*    */     } 
/* 69 */     return (r.bounty == vi);
/*    */   }
/*    */   
/*    */   static boolean portVisible(Raider r) {
/* 73 */     if (r.defeated)
/* 74 */       return true; 
/* 75 */     if (r.raids > 0)
/* 76 */       return true; 
/* 77 */     if (debug)
/* 78 */       return true; 
/* 79 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\raider\UIRaiding.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */