/*     */ package util.data;
/*     */ 
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ public class DataRandom<T>
/*     */ {
/*     */   private final LIST<INT_O.INT_OE<T>> randomness;
/*     */   private static final double rd = 9.536752259018191E-7D;
/*     */   
/*     */   public DataRandom(DataOSimple<T> data, int ints) {
/*  15 */     ArrayListGrower<INT_O.INT_OE<T>> all = new ArrayListGrower();
/*  16 */     for (int i = 0; i < ints; i++) {
/*  17 */       data.getClass(); all.add(new DataOSimple<T>.DataInt(data)
/*     */           {
/*     */             public int min(T t) {
/*  20 */               return Integer.MIN_VALUE; }
/*     */           });
/*     */     } 
/*  23 */     this.randomness = (LIST<INT_O.INT_OE<T>>)all;
/*     */   }
/*     */   
/*     */   public DataRandom(DataO<T> data, int ints) {
/*  27 */     ArrayListGrower<INT_O.INT_OE<T>> all = new ArrayListGrower();
/*  28 */     for (int i = 0; i < ints; i++) {
/*  29 */       all.add(new DataO<T>.DataInt(data, "RANDOM" + i)
/*     */           {
/*     */             public int min(T t) {
/*  32 */               return Integer.MIN_VALUE; }
/*     */           });
/*     */     } 
/*  35 */     this.randomness = (LIST<INT_O.INT_OE<T>>)all;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getD(T r, int startBit) {
/*  40 */     int ii = get(r, startBit, 20);
/*  41 */     return ii * 9.536752259018191E-7D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(T r, int startBit, int bits) {
/*  47 */     if (bits >= 32) {
/*  48 */       throw new RuntimeException();
/*     */     }
/*  50 */     startBit &= 32 * this.randomness.size() - 1;
/*  51 */     int ii = startBit / 32;
/*     */     
/*  53 */     long a = ((INT_O.INT_OE<T>)this.randomness.get(ii)).get(r);
/*  54 */     long b = ((INT_O.INT_OE<T>)this.randomness.getC(ii + 1)).get(r);
/*  55 */     a = a & 0xFFFFFFFFL | (b & 0xFFFFFFFFL) << 32L;
/*  56 */     startBit &= 0x1F;
/*     */     
/*  58 */     a >>>= startBit;
/*  59 */     a &= ((1 << bits) - 1);
/*     */     
/*  61 */     return (int)a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyFrom(T dest, T source) {
/*  67 */     for (int i = 0; i < this.randomness.size(); i++) {
/*  68 */       ((INT_O.INT_OE<T>)this.randomness.get(i)).set(dest, ((INT_O.INT_OE<T>)this.randomness.get(i)).get(source));
/*     */     }
/*     */   }
/*     */   
/*     */   public int get(T r, int startBit) {
/*  73 */     return get(r, startBit, 31);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getL(T r, int startBit) {
/*  79 */     long res = get(r, startBit);
/*  80 */     res <<= 32L;
/*  81 */     res |= get(r, startBit + 32);
/*  82 */     return res;
/*     */   }
/*     */   
/*     */   public void setLong(T r, int li, long ll) {
/*  86 */     ((INT_O.INT_OE<T>)this.randomness.get(li * 2)).set(r, (int)(ll >> 32L));
/*  87 */     ((INT_O.INT_OE<T>)this.randomness.get(li * 2 + 1)).set(r, (int)ll);
/*     */   }
/*     */   
/*     */   public LIST<INT_O.INT_OE<T>> all() {
/*  91 */     return this.randomness;
/*     */   }
/*     */   
/*     */   public void randomize(T r) {
/*  95 */     for (INT_O.INT_OE<T> i : this.randomness) {
/*  96 */       i.set(r, RND.rInt());
/*     */     }
/*     */   }
/*     */   
/*     */   static void main(String[] args) {
/* 101 */     DataOSimple<Test> dataa = new DataOSimple<Test>()
/*     */       {
/*     */         protected long[] data(DataRandom.Test t)
/*     */         {
/* 105 */           return t.data;
/*     */         }
/*     */       };
/*     */     
/* 109 */     DataRandom<Test> rr = new DataRandom<>(dataa, 4);
/*     */     
/* 111 */     double i8 = 0.0D;
/* 112 */     double i12 = 0.0D;
/* 113 */     double i16 = 0.0D;
/* 114 */     double i20 = 0.0D;
/* 115 */     double i24 = 0.0D;
/* 116 */     double i28 = 0.0D;
/* 117 */     double i31 = 0.0D;
/*     */     
/* 119 */     for (int i = 0; i < 1000; i++) {
/* 120 */       Test t = new Test();
/* 121 */       t.data = new long[dataa.longCount()];
/* 122 */       rr.randomize(t);
/*     */       
/* 124 */       i8 += rr.get(t, 12, 8);
/* 125 */       i12 += rr.get(t, 12, 12);
/* 126 */       i16 += rr.get(t, 12, 16);
/* 127 */       i20 += rr.get(t, 12, 20);
/* 128 */       i24 += rr.get(t, 12, 24);
/* 129 */       i28 += rr.get(t, 12, 28);
/* 130 */       i31 += rr.get(t, 12, 31);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     LOG.ln(Double.valueOf(i8 / 255000.0D));
/* 137 */     LOG.ln(Double.valueOf(i12 / 4095000.0D));
/* 138 */     LOG.ln(Double.valueOf(i16 / 6.5535E7D));
/* 139 */     LOG.ln(Double.valueOf(i20 / 1.048575E9D));
/* 140 */     LOG.ln(Double.valueOf(i24 / 1.6777215E10D));
/* 141 */     LOG.ln(Double.valueOf(i28 / 2.68435455E11D));
/* 142 */     LOG.ln(Double.valueOf(i31 / 2.147483647E12D));
/*     */   }
/*     */   
/*     */   private static final class Test {
/*     */     long[] data;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DataRandom.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */