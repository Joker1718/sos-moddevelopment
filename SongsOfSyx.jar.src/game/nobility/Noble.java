/*     */ package game.nobility;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import util.gui.misc.GBox;
/*     */ 
/*     */ public final class Noble
/*     */   implements INDEXED
/*     */ {
/*     */   public final short index;
/*  20 */   private int subjectID = -1;
/*  21 */   private int office = -1;
/*  22 */   private int rank = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */ 
/*     */   
/*     */   public Humanoid subject() {
/*  31 */     if (this.subjectID == -1)
/*  32 */       return null; 
/*  33 */     ENTITY e = SETT.ENTITIES().getByID(this.subjectID);
/*  34 */     if (e != null && e instanceof Humanoid) {
/*  35 */       return (Humanoid)e;
/*     */     }
/*  37 */     this.subjectID = -1;
/*  38 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   void rankInc() {
/*  43 */     if (this.rank < GAME.NOBLE().maxRanks() - 1) {
/*  44 */       this.rank++;
/*     */     }
/*     */   }
/*     */   
/*     */   void assign(Humanoid h) {
/*  49 */     this.saver.clear();
/*  50 */     this.subjectID = h.id();
/*  51 */     update(0.0D);
/*     */   }
/*     */   
/*     */   void setOffice(NobleOffice office) {
/*  55 */     this.office = (office == null) ? -1 : office.index;
/*     */   }
/*     */   
/*     */   void update(double ds) {
/*  59 */     subject();
/*     */   }
/*     */ 
/*     */   
/*     */   Noble(ArrayList<Noble> ii) {
/*  64 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  68 */           file.i(Noble.this.subjectID);
/*  69 */           file.i(Noble.this.rank);
/*  70 */           file.i(Noble.this.office);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  75 */           Noble.this.subjectID = file.i();
/*  76 */           Noble.this.rank = file.i();
/*  77 */           Noble.this.office = file.i();
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  82 */           Noble.this.subjectID = -1;
/*  83 */           Noble.this.rank = 0;
/*  84 */           Noble.this.office = -1;
/*     */         }
/*     */       };
/*     */     this.index = (short)ii.add(this);
/*     */   } public NobleOffice office() {
/*  89 */     if (this.office < 0 || this.office >= (GAME.NOBLE()).OFFICES.size())
/*  90 */       return null; 
/*  91 */     return (NobleOffice)(GAME.NOBLE()).OFFICES.get(this.office);
/*     */   }
/*     */   
/*     */   public CharSequence title() {
/*  95 */     NobleOffice n = office();
/*  96 */     if (n == null)
/*  97 */       return rankName(); 
/*  98 */     return n.name;
/*     */   }
/*     */   
/*     */   public int rank() {
/* 102 */     return this.rank;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverOffice(GUI_BOX box) {
/* 107 */     NobleOffice o = office();
/* 108 */     if (o == null)
/*     */       return; 
/* 110 */     GBox b = (GBox)box;
/*     */     
/* 112 */     b.title(o.name);
/* 113 */     b.text(o.desc);
/* 114 */     b.NL();
/*     */     
/* 116 */     o.hoverValue(b, 1 + rank() * 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence rankName() {
/* 121 */     return (GAME.NOBLE()).nameRanks[this.rank];
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 126 */     return this.index;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\nobility\Noble.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */