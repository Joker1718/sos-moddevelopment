/*     */ package game.boosting.superb;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SuperSpecImp<T extends SuperBoostableObj>
/*     */   extends SuperSpec<T>
/*     */ {
/*     */   public final int index;
/*     */   public final String key;
/*     */   public final DOUBLE_O.DOUBLE_OE<SuperBoostableObj> value;
/*     */   public final DOUBLE_O.DOUBLE_OE<SuperBoostableObj> time;
/*     */   public final DOUBLE_O.DOUBLE_OE<T> state;
/*     */   
/*     */   public SuperSpecImp(SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul) {
/*  64 */     super(self, info, desc, to, isMul);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     this.value = new DOUBLE_O.DOUBLE_OE<SuperBoostableObj>()
/*     */       {
/*     */         public double getD(SuperBoostableObj t)
/*     */         {
/*  78 */           return t.boostingData().values()[SuperSpec.SuperSpecImp.this.index];
/*     */         }
/*     */ 
/*     */         
/*     */         public DOUBLE_O.DOUBLE_OE<SuperBoostableObj> setD(SuperBoostableObj t, double d) {
/*  83 */           t.boostingData().values()[SuperSpec.SuperSpecImp.this.index] = CLAMP.d(d, 0.0D, 1.0D);
/*  84 */           return this;
/*     */         }
/*     */       };
/*     */     
/*  88 */     this.time = new DOUBLE_O.DOUBLE_OE<SuperBoostableObj>()
/*     */       {
/*     */         public double getD(SuperBoostableObj t)
/*     */         {
/*  92 */           return t.boostingData().times()[SuperSpec.SuperSpecImp.this.index];
/*     */         }
/*     */ 
/*     */         
/*     */         public DOUBLE_O.DOUBLE_OE<SuperBoostableObj> setD(SuperBoostableObj t, double d) {
/*  97 */           t.boostingData().times()[SuperSpec.SuperSpecImp.this.index] = d;
/*  98 */           return this;
/*     */         }
/*     */       };
/*     */     
/* 102 */     this.state = new DOUBLE_O.DOUBLE_OE<T>()
/*     */       {
/*     */         public double getD(T t)
/*     */         {
/* 106 */           return t.boostingData().states()[SuperSpec.SuperSpecImp.this.index];
/*     */         }
/*     */ 
/*     */         
/*     */         public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 111 */           t.boostingData().states()[SuperSpec.SuperSpecImp.this.index] = d;
/* 112 */           return this; } };
/*     */     while (self.map.containsKey(key))
/*     */       key = key + "0"; 
/*     */     this.key = key;
/*     */     self.map.put(this.key, this);
/* 117 */     this.index = self.ups.add(this); } public void toggle(T bo) { activate(bo, !activated(bo)); }
/*     */ 
/*     */   
/*     */   public abstract void update(T paramT, double paramDouble);
/*     */   
/*     */   public abstract void activate(T paramT, boolean paramBoolean);
/*     */   
/*     */   public abstract boolean activated(T paramT);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperSpec$SuperSpecImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */