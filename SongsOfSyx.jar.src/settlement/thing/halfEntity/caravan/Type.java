/*    */ package settlement.thing.halfEntity.caravan;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import util.gui.misc.GBox;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class Type
/*    */ {
/* 13 */   static final ArrayList<Type> all = new ArrayList(10);
/*    */ 
/*    */ 
/*    */   
/*    */   final int index;
/*    */ 
/*    */ 
/*    */   
/*    */   final CharSequence name;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   Type(CharSequence name) {
/* 27 */     this.name = name;
/* 28 */     this.index = all.add(this);
/*    */   }
/*    */   
/* 31 */   static final Coo coo = new Coo();
/*    */   
/*    */   abstract boolean init(Caravan paramCaravan, int paramInt);
/*    */   
/*    */   abstract boolean update(Caravan paramCaravan, double paramDouble);
/*    */   
/*    */   abstract void cancel(Caravan paramCaravan, boolean paramBoolean);
/*    */   
/*    */   public abstract void hoverInfo(GBox paramGBox, Caravan paramCaravan);
/*    */   
/*    */   protected abstract void load(Caravan paramCaravan);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\caravan\Type.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */