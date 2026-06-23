/*    */ package settlement.battle.invasion;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ public abstract class InvasionListener
/*    */ {
/*  9 */   static final ArrayListGrower<InvasionListener> all = new ArrayListGrower();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InvasionListener() {
/* 20 */     all.add(this);
/*    */   }
/*    */   
/*    */   protected abstract void register(WArmy paramWArmy, int paramInt);
/*    */   
/*    */   protected abstract void defeat(int paramInt1, int paramInt2, int paramInt3);
/*    */   
/*    */   protected abstract void victory(int paramInt1, int paramInt2, int paramInt3);
/*    */   
/*    */   protected abstract void weirdness(int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\InvasionListener.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */