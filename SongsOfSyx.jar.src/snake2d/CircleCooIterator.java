/*     */ package snake2d;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ 
/*     */ 
/*     */ public final class CircleCooIterator
/*     */ {
/*     */   private final ArrayCooShort coos;
/*     */   private final byte[] radiuses;
/*     */   private final byte[] sides;
/*     */   
/*     */   public CircleCooIterator(int radius, PathUtilOnline.Flooder p) {
/*  16 */     if (radius > 127) {
/*  17 */       throw new RuntimeException();
/*     */     }
/*     */     
/*  20 */     p.init(this);
/*     */     
/*  22 */     int amount = 0;
/*  23 */     p.pushSloppy(radius, radius, 0.0D);
/*     */     
/*  25 */     while (p.hasMore()) {
/*     */       
/*  27 */       PathTile t = p.pollSmallest();
/*  28 */       if (t.getValue() > radius) {
/*     */         break;
/*     */       }
/*  31 */       amount++;
/*     */       
/*  33 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/*  34 */         DIR d = (DIR)DIR.ALL.get(i);
/*  35 */         int x = t.x() + d.x();
/*  36 */         int y = t.y() + d.y();
/*  37 */         if (x >= 0 && y >= 0) {
/*     */           
/*  39 */           double v = Math.sqrt(((x - radius) * (x - radius) + (y - radius) * (y - radius)));
/*  40 */           p.pushSmaller(x, y, v);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  45 */     this.coos = new ArrayCooShort(amount);
/*  46 */     this.radiuses = Alloc.bb(amount);
/*  47 */     this.sides = Alloc.bb(amount);
/*     */     
/*  49 */     p.done();
/*     */ 
/*     */ 
/*     */     
/*  53 */     p.init(this);
/*     */     
/*  55 */     int index = 0;
/*  56 */     p.pushSloppy(radius, radius, 0.0D);
/*     */     
/*  58 */     while (p.hasMore()) {
/*     */       
/*  60 */       PathTile t = p.pollSmallest();
/*  61 */       if (t.getValue() > radius) {
/*     */         break;
/*     */       }
/*  64 */       this.coos.set(index).set((t.x() - radius), (t.y() - radius));
/*  65 */       this.radiuses[index] = (byte)(int)t.getValue();
/*  66 */       this.sides[index] = (byte)((Math.abs(t.x() - radius) > Math.abs(t.y() - radius)) ? Math.abs(t.x() - radius) : Math.abs(t.y() - radius));
/*  67 */       index++;
/*     */       
/*  69 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/*  70 */         DIR d = (DIR)DIR.ALL.get(i);
/*  71 */         int x = t.x() + d.x();
/*  72 */         int y = t.y() + d.y();
/*  73 */         if (x >= 0 && y >= 0) {
/*     */           
/*  75 */           double v = Math.sqrt(((x - radius) * (x - radius) + (y - radius) * (y - radius)));
/*  76 */           p.pushSmaller(x, y, v);
/*     */         } 
/*     */       } 
/*     */     } 
/*  80 */     p.done();
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE get(int index) {
/*  85 */     return (COORDINATE)this.coos.set(index);
/*     */   }
/*     */   
/*     */   public int radius(int index) {
/*  89 */     return this.radiuses[index];
/*     */   }
/*     */   
/*     */   public int sideLength(int index) {
/*  93 */     return this.sides[index];
/*     */   }
/*     */   
/*     */   public int length() {
/*  97 */     return this.coos.size();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 101 */     CircleCooIterator c = new CircleCooIterator(50, (new PathUtilOnline(200)).getFlooder());
/*     */     
/* 103 */     int i = 0;
/* 104 */     while (c.sideLength(i) <= 5) {
/* 105 */       Printer.ln(String.valueOf(c.get(i).x()) + " " + c.get(i).y());
/* 106 */       i++;
/*     */     } 
/* 108 */     Printer.ln(Integer.valueOf(i));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\CircleCooIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */