/*     */ package init.resources;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RBIT
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  18 */   public static final RBIT NONE = new RBIT();
/*  19 */   public static final RBIT ALL = new RBIT(-1L, -1L);
/*     */   
/*     */   protected long l1;
/*     */   
/*     */   protected long l2;
/*     */ 
/*     */   
/*     */   public RBIT() {}
/*     */   
/*     */   RBIT(long l1, long l2) {
/*  29 */     this.l1 = l1;
/*  30 */     this.l2 = l2;
/*     */   }
/*     */   
/*     */   public boolean has(RESOURCE res) {
/*  34 */     return !((this.l1 & res.bitL1) == 0L && (this.l2 & res.bitL2) == 0L);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean has(RBIT other) {
/*  39 */     if (other == null)
/*  40 */       return false; 
/*  41 */     return !((this.l1 & other.l1) == 0L && (this.l2 & other.l2) == 0L);
/*     */   }
/*     */   
/*     */   public boolean hasAll(RBIT other) {
/*  45 */     if (other == null)
/*  46 */       return false; 
/*  47 */     return ((this.l1 & other.l1) == other.l1 && (this.l2 & other.l2) == other.l2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  52 */     return Long.toBinaryString(this.l2) + " " + Long.toBinaryString(this.l2);
/*     */   }
/*     */   
/*     */   public boolean isClear() {
/*  56 */     return (this.l1 == 0L && this.l2 == 0L);
/*     */   }
/*     */   
/*     */   public void debug() {
/*  60 */     LOG.ln("rbits");
/*  61 */     for (RESOURCE res : RESOURCES.ALL()) {
/*  62 */       if (has(res))
/*  63 */         LOG.ln(res); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class RBITImp
/*     */     extends RBIT implements SAVABLE {
/*  69 */     public static RBITImp tmp = new RBITImp();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RBITImp and(RESOURCE res) {
/*  80 */       this.l1 &= res.bitL1;
/*  81 */       this.l2 &= res.bitL2;
/*  82 */       return this;
/*     */     }
/*     */     
/*     */     public RBITImp and(RBIT other) {
/*  86 */       this.l1 &= other.l1;
/*  87 */       this.l2 &= other.l2;
/*  88 */       return this;
/*     */     }
/*     */     
/*     */     public RBITImp or(RESOURCE res) {
/*  92 */       this.l1 |= res.bitL1;
/*  93 */       this.l2 |= res.bitL2;
/*  94 */       return this;
/*     */     }
/*     */     
/*     */     public RBITImp or(RBIT other) {
/*  98 */       this.l1 |= other.l1;
/*  99 */       this.l2 |= other.l2;
/* 100 */       return this;
/*     */     }
/*     */     
/*     */     public RBITImp clear(RESOURCE res) {
/* 104 */       this.l1 &= res.bitL1 ^ 0xFFFFFFFFFFFFFFFFL;
/* 105 */       this.l2 &= res.bitL2 ^ 0xFFFFFFFFFFFFFFFFL;
/* 106 */       return this;
/*     */     }
/*     */     
/*     */     public RBITImp clear(RBIT other) {
/* 110 */       this.l1 &= other.l1 ^ 0xFFFFFFFFFFFFFFFFL;
/* 111 */       this.l2 &= other.l2 ^ 0xFFFFFFFFFFFFFFFFL;
/* 112 */       return this;
/*     */     }
/*     */     
/*     */     public RBITImp setAll() {
/* 116 */       this.l1 = -1L;
/* 117 */       this.l2 = -1L;
/* 118 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 123 */       this.l1 = 0L;
/* 124 */       this.l2 = 0L;
/*     */     }
/*     */     
/*     */     public RBITImp clearSet(RBIT other) {
/* 128 */       this.l1 = other.l1;
/* 129 */       this.l2 = other.l2;
/* 130 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 135 */       file.l(this.l1);
/* 136 */       file.l(this.l2);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 141 */       this.l1 = file.l();
/* 142 */       this.l2 = file.l();
/*     */     }
/*     */     
/*     */     public void toggle(RESOURCE resource) {
/* 146 */       this.l1 ^= resource.bitL1;
/* 147 */       this.l2 ^= resource.bitL2;
/*     */     }
/*     */     
/*     */     public void xor(RBIT bits) {
/* 151 */       this.l1 &= bits.l1 ^ 0xFFFFFFFFFFFFFFFFL;
/* 152 */       this.l2 &= bits.l2 ^ 0xFFFFFFFFFFFFFFFFL;
/*     */     }
/*     */ 
/*     */     
/*     */     public void flip() {
/* 157 */       this.l1 ^= 0xFFFFFFFFFFFFFFFFL;
/* 158 */       this.l2 ^= 0xFFFFFFFFFFFFFFFFL;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(RESOURCE res, boolean yes) {
/* 163 */       if (yes) {
/* 164 */         or(res);
/*     */       } else {
/* 166 */         clear(res);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\RBIT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */