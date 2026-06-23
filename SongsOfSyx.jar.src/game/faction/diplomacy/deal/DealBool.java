/*    */ package game.faction.diplomacy.deal;
/*    */ 
/*    */ import game.faction.diplomacy.DipStance;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.Debugger;
/*    */ import util.data.BOOLEAN;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public abstract class DealBool
/*    */   implements BOOLEAN.BOOLEAN_MUTABLE
/*    */ {
/*    */   public final INFO info;
/*    */   public final SPRITE icon;
/*    */   private boolean toggled;
/*    */   
/*    */   DealBool(LISTE<DealBool> bools, CharSequence name, CharSequence desc, SPRITE icon) {
/* 19 */     this.info = new INFO(name, desc);
/* 20 */     this.icon = icon;
/* 21 */     bools.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract CharSequence problem();
/*    */   
/*    */   public abstract double value();
/*    */   
/*    */   public abstract void execute();
/*    */   
/*    */   protected abstract void pInit(DealParty paramDealParty1, DealParty paramDealParty2, Debugger paramDebugger);
/*    */   
/*    */   protected abstract DipStance stance();
/*    */   
/*    */   public boolean is() {
/* 36 */     return this.toggled;
/*    */   }
/*    */ 
/*    */   
/*    */   public BOOLEAN.BOOLEAN_MUTABLE set(boolean b) {
/* 41 */     this.toggled = b;
/* 42 */     return this;
/*    */   }
/*    */   
/*    */   public void hover(GBox b) {
/* 46 */     b.title(this.info.name);
/* 47 */     b.text(this.info.desc);
/* 48 */     b.NL();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealBool.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */