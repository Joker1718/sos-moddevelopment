/*    */ package game.raiding;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.D;
/*    */ import view.main.VIEW;
/*    */ import view.ui.message.MessageSection;
/*    */ 
/*    */ final class MessArmyAppear extends MessageSection {
/* 14 */   private static CharSequence ¤¤title = "Raiders Arrived";
/* 15 */   private static CharSequence ¤¤desc = "{0} has been spotted at our borders Milord. Death and destruction will follow in {1} path to our capital. We must put a stop to this now."; private static final long serialVersionUID = 1L;
/*    */   
/*    */   static {
/* 18 */     D.ts(MessArmyAppear.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private final Raider raider;
/*    */   
/*    */   private final int x;
/*    */   
/*    */   private final int y;
/*    */ 
/*    */   
/*    */   public MessArmyAppear(Raider raider, int x, int y) {
/* 30 */     super(¤¤title);
/* 31 */     this.raider = raider;
/* 32 */     this.x = x;
/* 33 */     this.y = y;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void make(GuiSection section) {
/* 39 */     Str.TMP.clear().add(¤¤desc);
/* 40 */     Str.TMP.insert(0, this.raider.name);
/* 41 */     Str.TMP.insert(1, (this.raider.indu.race()).info.pHIS.get(this.raider.indu, false));
/* 42 */     paragraph((CharSequence)Str.TMP);
/* 43 */     section.addRelBody(32, DIR.N, (SPRITE)(new RaiderPortrait(4)).set(this.raider));
/*    */     
/* 45 */     section.addRelBody(16, DIR.S, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*    */         {
/*    */           protected void clickA()
/*    */           {
/* 49 */             VIEW.world().activate();
/* 50 */             (VIEW.world()).window.setZoomout(0);
/* 51 */             (VIEW.world()).window.centererTile.set(MessArmyAppear.this.x, MessArmyAppear.this.y);
/*    */           }
/* 55 */         }).setDim(48));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessArmyAppear.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */