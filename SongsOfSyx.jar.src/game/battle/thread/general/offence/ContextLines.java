/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ class ContextLines
/*     */   implements SAVABLE
/*     */ {
/*     */   private int lineI;
/*  17 */   private Line[] all = new Line[0];
/*  18 */   private static final VectorImp vec = new VectorImp();
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Line
/*     */     implements SAVABLE
/*     */   {
/*     */     int sx;
/*     */ 
/*     */     
/*     */     int sy;
/*     */ 
/*     */     
/*     */     int length;
/*     */     
/*     */     double dx;
/*     */     
/*     */     double dy;
/*     */     
/*     */     byte mark;
/*     */     
/*     */     int back;
/*     */     
/*     */     int blobID;
/*     */ 
/*     */     
/*     */     public int cx() {
/*  45 */       return (int)(this.sx + this.dx * this.length / 2.0D);
/*     */     }
/*     */     public int cy() {
/*  48 */       return (int)(this.sy + this.dy * this.length / 2.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public DivFormation deploy(StrategosUtil util, Div d) {
/*  53 */       int m = d.menNrOf();
/*  54 */       if (m == 0)
/*  55 */         return null; 
/*  56 */       int w = (int)Math.sqrt(m);
/*  57 */       if (w == 0) {
/*  58 */         return null;
/*     */       }
/*  60 */       int x = this.sx;
/*  61 */       int y = this.sy;
/*     */       
/*  63 */       ContextLines.vec.set(this.dx, this.dy);
/*  64 */       ContextLines.vec.rotate90();
/*  65 */       x = (int)(x + this.back * ContextLines.vec.nX());
/*  66 */       y = (int)(y + this.back * ContextLines.vec.nY());
/*     */       
/*  68 */       DivFormation f = util.divDeployer.deploy(d, x, y, this.length, this.dx, this.dy);
/*     */       
/*  70 */       if (f != null) {
/*  71 */         this.back = (int)(this.back + (d.settings()).formation.size(d) * Math.ceil((m /= this.length / (d.settings()).formation.size(d))) + 64.0D);
/*     */       }
/*     */       
/*  74 */       return f;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/*  81 */       file.i(this.sx);
/*  82 */       file.i(this.sy);
/*  83 */       file.i(this.length);
/*  84 */       file.d(this.dx);
/*  85 */       file.d(this.dy);
/*  86 */       file.i(this.back);
/*  87 */       file.b(this.mark);
/*  88 */       file.i(this.blobID);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/*  94 */       this.sx = file.i();
/*  95 */       this.sy = file.i();
/*  96 */       this.length = file.i();
/*  97 */       this.dx = file.d();
/*  98 */       this.dy = file.d();
/*  99 */       this.back = file.i();
/* 100 */       this.mark = file.b();
/* 101 */       this.blobID = file.i();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void clear() {
/* 107 */       this.sx = 0;
/* 108 */       this.sy = 0;
/* 109 */       this.length = 1;
/* 110 */       this.dx = 1.0D;
/* 111 */       this.dy = 0.0D;
/* 112 */       this.back = 0;
/* 113 */       this.mark = 0;
/* 114 */       this.blobID = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Line get(int index) {
/* 121 */     if (index >= this.lineI)
/* 122 */       throw new RuntimeException(); 
/* 123 */     return this.all[index];
/*     */   }
/*     */   
/*     */   public void remove(int index) {
/* 127 */     Line l = this.all[index];
/* 128 */     this.all[index] = this.all[this.lineI - 1];
/* 129 */     this.all[this.lineI - 1] = l;
/* 130 */     this.lineI--;
/*     */   }
/*     */   
/*     */   public int lines() {
/* 134 */     return this.lineI;
/*     */   }
/*     */   
/*     */   public Line makeNew() {
/* 138 */     if (this.lineI >= this.all.length) {
/* 139 */       Line[] lines2 = new Line[this.all.length + 256]; int i;
/* 140 */       for (i = 0; i < this.all.length; i++) {
/* 141 */         lines2[i] = this.all[i];
/*     */       }
/* 143 */       for (i = this.all.length; i < lines2.length; i++) {
/* 144 */         lines2[i] = new Line();
/*     */       }
/* 146 */       this.all = lines2;
/*     */     } 
/* 148 */     Line l = this.all[this.lineI];
/* 149 */     l.clear();
/* 150 */     this.lineI++;
/* 151 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 156 */     file.i(this.all.length);
/* 157 */     file.i(this.lineI);
/*     */     
/* 159 */     for (int i = 0; i < this.lineI; i++) {
/* 160 */       Line l = this.all[i];
/* 161 */       l.save(file);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 168 */     this.all = new Line[file.i()]; int i;
/* 169 */     for (i = 0; i < this.all.length; i++) {
/* 170 */       this.all[i] = new Line();
/*     */     }
/* 172 */     this.lineI = file.i();
/*     */ 
/*     */     
/* 175 */     for (i = 0; i < this.lineI; i++) {
/* 176 */       Line l = this.all[i];
/* 177 */       l.load(file);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 185 */     this.lineI = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\ContextLines.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */