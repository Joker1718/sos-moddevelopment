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
/*    */ final class MessArmySpotted extends MessageSection {
/* 14 */   private static CharSequence ¤¤title = "Raiders Approaching";
/* 15 */   private static CharSequence ¤¤desc = "{0} and {1} band of raiders are approaching our borders Milord. They are only 3 days march away. We must prepare for {2} arrival."; private static final long serialVersionUID = 1L;
/*    */   
/*    */   static {
/* 18 */     D.ts(MessArmySpotted.class);
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
/*    */   public MessArmySpotted(Raider raider, int x, int y) {
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
/* 42 */     Str.TMP.insert(2, (this.raider.indu.race()).info.pHIS.get(this.raider.indu, false));
/* 43 */     paragraph((CharSequence)Str.TMP);
/* 44 */     section.addRelBody(32, DIR.N, (SPRITE)(new RaiderPortrait(4)).set(this.raider));
/*    */     
/* 46 */     section.addRelBody(16, DIR.S, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*    */         {
/*    */           protected void clickA()
/*    */           {
/* 50 */             VIEW.world().activate();
/* 51 */             (VIEW.world()).window.setZoomout(0);
/* 52 */             (VIEW.world()).window.centererTile.set(MessArmySpotted.this.x, MessArmySpotted.this.y);
/*    */           }
/* 56 */         }).setDim(48));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessArmySpotted.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */