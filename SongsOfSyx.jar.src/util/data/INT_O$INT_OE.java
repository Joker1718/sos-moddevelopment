/*     */ package util.data;
/*     */ 
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ public interface INT_OE<T>
/*     */   extends INT_O<T>, DOUBLE_O.DOUBLE_OE<T>
/*     */ {
/*     */   default void setMax(T t) {
/*  26 */     set(t, max(t));
/*     */   }
/*     */ 
/*     */   
/*     */   default DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/*  31 */     set(t, (int)(max(t) * d));
/*  32 */     return this;
/*     */   }
/*     */   void set(T paramT, int paramInt);
/*     */   default DOUBLE_O.DOUBLE_OE<T> incD(T t, double d) {
/*  36 */     int i = (int)(max(t) * d);
/*  37 */     if (i == 0)
/*  38 */       if (d < 0.0D) {
/*  39 */         i = -1;
/*     */       } else {
/*  41 */         i = 1;
/*  42 */       }   inc(t, i);
/*  43 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   default void inc(T t, int i) {
/*  49 */     set(t, CLAMP.i(get(t) + i, min(t), max(t)));
/*     */   }
/*     */   
/*     */   default void incFraction(T t, double d) {
/*  53 */     int am = (int)d;
/*  54 */     if (am != d)
/*  55 */       if (d < 0.0D && -d - am > RND.rFloat()) {
/*  56 */         am--;
/*  57 */       } else if (d > 0.0D && d - am > RND.rFloat()) {
/*  58 */         am++;
/*     */       }  
/*  60 */     set(t, CLAMP.i(get(t) + am, min(t), max(t)));
/*     */   }
/*     */   
/*     */   default DOUBLE_O.DOUBLE_OE<T> moveTo(T t, double d, int target) {
/*  64 */     int am = (int)d;
/*  65 */     if (am != d)
/*  66 */       if (d < 0.0D && -(d + am) > RND.rFloat()) {
/*  67 */         am--;
/*  68 */       } else if (d > 0.0D && d - am > RND.rFloat()) {
/*  69 */         am++;
/*     */       }  
/*  71 */     int c = get(t);
/*  72 */     if (c < target) {
/*  73 */       c += am;
/*  74 */       if (c > target)
/*  75 */         c = target; 
/*     */     } else {
/*  77 */       c -= am;
/*  78 */       if (c < target) {
/*  79 */         c = target;
/*     */       }
/*     */     } 
/*  82 */     set(t, CLAMP.i(c, min(t), max(t)));
/*  83 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   default void andSet(T t, int i) {
/*  88 */     set(t, get(t) & i);
/*     */   }
/*     */   
/*     */   default void orSet(T t, int i) {
/*  92 */     set(t, get(t) | i);
/*     */   }
/*     */   
/*     */   default INT.INTE createInt(final T t) {
/*  96 */     return new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 100 */           return INT_O.INT_OE.this.min(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 105 */           return INT_O.INT_OE.this.max(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 110 */           return INT_O.INT_OE.this.get(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int k) {
/* 115 */           INT_O.INT_OE.this.set(t, k);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   default INT.INTE createIntInverted(final T t) {
/* 121 */     return new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 125 */           return INT_O.INT_OE.this.min(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 130 */           return INT_O.INT_OE.this.max(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 135 */           return max() - INT_O.INT_OE.this.get(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int k) {
/* 140 */           INT_O.INT_OE.this.set(t, max() - k);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\INT_O$INT_OE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */