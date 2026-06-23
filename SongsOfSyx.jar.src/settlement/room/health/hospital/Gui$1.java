/*    */ package settlement.room.health.hospital;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.value.Lockable;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GButt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 41 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 45 */     selectedSet(((HospitalInstance)getter.get()).fetch[k]);
/* 46 */     activeSet(((Lockable)((ROOM_HOSPITAL)Gui.access$1(Gui.this)).resLocks.get(k)).passes(FACTIONS.player()));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 51 */     ((HospitalInstance)getter.get()).fetch[k] = !((HospitalInstance)getter.get()).fetch[k];
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 56 */     super.hoverInfoGet(text);
/* 57 */     text.NL();
/* 58 */     ((Lockable)((ROOM_HOSPITAL)Gui.access$1(Gui.this)).resLocks.get(k)).hover(text, FACTIONS.player());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */