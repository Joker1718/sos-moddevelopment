/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
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
/*     */ public class Line
/*     */   implements SAVABLE
/*     */ {
/*     */   int sx;
/*     */   int sy;
/*     */   int length;
/*     */   double dx;
/*     */   double dy;
/*     */   byte mark;
/*     */   int back;
/*     */   int blobID;
/*     */   
/*     */   public int cx() {
/*  45 */     return (int)(this.sx + this.dx * this.length / 2.0D);
/*     */   }
/*     */   public int cy() {
/*  48 */     return (int)(this.sy + this.dy * this.length / 2.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public DivFormation deploy(StrategosUtil util, Div d) {
/*  53 */     int m = d.menNrOf();
/*  54 */     if (m == 0)
/*  55 */       return null; 
/*  56 */     int w = (int)Math.sqrt(m);
/*  57 */     if (w == 0) {
/*  58 */       return null;
/*     */     }
/*  60 */     int x = this.sx;
/*  61 */     int y = this.sy;
/*     */     
/*  63 */     ContextLines.vec.set(this.dx, this.dy);
/*  64 */     ContextLines.vec.rotate90();
/*  65 */     x = (int)(x + this.back * ContextLines.vec.nX());
/*  66 */     y = (int)(y + this.back * ContextLines.vec.nY());
/*     */     
/*  68 */     DivFormation f = util.divDeployer.deploy(d, x, y, this.length, this.dx, this.dy);
/*     */     
/*  70 */     if (f != null) {
/*  71 */       this.back = (int)(this.back + (d.settings()).formation.size(d) * Math.ceil((m /= this.length / (d.settings()).formation.size(d))) + 64.0D);
/*     */     }
/*     */     
/*  74 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  81 */     file.i(this.sx);
/*  82 */     file.i(this.sy);
/*  83 */     file.i(this.length);
/*  84 */     file.d(this.dx);
/*  85 */     file.d(this.dy);
/*  86 */     file.i(this.back);
/*  87 */     file.b(this.mark);
/*  88 */     file.i(this.blobID);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  94 */     this.sx = file.i();
/*  95 */     this.sy = file.i();
/*  96 */     this.length = file.i();
/*  97 */     this.dx = file.d();
/*  98 */     this.dy = file.d();
/*  99 */     this.back = file.i();
/* 100 */     this.mark = file.b();
/* 101 */     this.blobID = file.i();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 107 */     this.sx = 0;
/* 108 */     this.sy = 0;
/* 109 */     this.length = 1;
/* 110 */     this.dx = 1.0D;
/* 111 */     this.dy = 0.0D;
/* 112 */     this.back = 0;
/* 113 */     this.mark = 0;
/* 114 */     this.blobID = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\ContextLines$Line.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */