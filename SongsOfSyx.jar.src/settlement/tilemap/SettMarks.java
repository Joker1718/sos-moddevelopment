/*     */ package settlement.tilemap;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.ShortCoo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ public final class SettMarks extends TileMap.Resource {
/*  18 */   public final int max = 32;
/*     */   public int state;
/*     */   public final LIST<SettMark> all;
/*  21 */   private final ArrayList<SettMark> active = new ArrayList(32);
/*     */ 
/*     */ 
/*     */   
/*     */   int upI;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SettMarks() {
/*  31 */     this.upI = 0; ArrayList<SettMark> all = new ArrayList(32);
/*     */     while (all.hasRoom())
/*     */       all.add(new SettMark()); 
/*  34 */     this.all = (LIST<SettMark>)all; } public LIST<SettMark> active() { if (this.upI == GAME.updateI())
/*  35 */       return (LIST<SettMark>)this.active; 
/*  36 */     this.upI = GAME.updateI();
/*  37 */     this.active.clearSloppy();
/*  38 */     for (SettMark s : this.all) {
/*  39 */       if (s.active)
/*  40 */         this.active.add(s); 
/*  41 */     }  return (LIST<SettMark>)this.active; }
/*     */ 
/*     */   
/*     */   public int state() {
/*  45 */     return this.state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  52 */     file.i(this.state);
/*  53 */     for (SettMark d : this.all) {
/*  54 */       file.bool(d.active);
/*  55 */       file.i(d.tile.x());
/*  56 */       file.i(d.tile.y());
/*     */       
/*  58 */       d.color.save(file);
/*  59 */       d.name.save(file);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  67 */     this.active.clear();
/*  68 */     this.state = file.i();
/*  69 */     for (SettMark d : this.all) {
/*  70 */       d.active = file.bool();
/*  71 */       d.tile.set(file.i(), file.i());
/*  72 */       d.color.load(file);
/*  73 */       d.name.load(file);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearAll() {
/*  80 */     this.state = 0;
/*  81 */     for (SettMark d : this.all) {
/*  82 */       d.active = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public SettMark make() {
/*  87 */     for (SettMark d : this.all) {
/*  88 */       if (!d.active) {
/*  89 */         d.active = true;
/*  90 */         this.state++;
/*  91 */         return d;
/*     */       } 
/*     */     } 
/*  94 */     return null;
/*     */   }
/*     */   
/*     */   public final class SettMark
/*     */     implements SAVABLE
/*     */   {
/* 100 */     public final ShortCoo tile = new ShortCoo();
/* 101 */     public final ColorImp color = new ColorImp();
/* 102 */     public final Str name = new Str(20);
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean active;
/*     */ 
/*     */ 
/*     */     
/*     */     public void setPosition(int position) {
/* 111 */       int i = 0;
/* 112 */       for (SettMark d : SettMarks.this.active()) {
/* 113 */         if (i == position) {
/* 114 */           if (d == this)
/*     */             return; 
/* 116 */           if (!d.active)
/*     */             return; 
/* 118 */           SettMarks.this.state++;
/* 119 */           int tx = d.tile.x();
/* 120 */           int ty = d.tile.y();
/* 121 */           ColorImp.TMP.set((COLOR)d.color);
/* 122 */           Str.TMP.clear().add((CharSequence)d.name);
/*     */           
/* 124 */           d.tile.set((COORDINATE)this.tile);
/* 125 */           d.color.set((COLOR)this.color);
/* 126 */           d.name.clear().add((CharSequence)this.name);
/*     */           
/* 128 */           this.tile.set(tx, ty);
/* 129 */           this.color.set((COLOR)ColorImp.TMP);
/* 130 */           this.name.clear().add((CharSequence)Str.TMP);
/*     */         } 
/* 132 */         if (d.active) {
/* 133 */           i++;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int tx, int ty) {
/* 140 */       this.active = true;
/* 141 */       this.tile.set(tx, ty);
/* 142 */       this.color.set(RND.rInt(127), RND.rInt(127), RND.rInt(127));
/*     */       
/* 144 */       this.name.clear().add('?');
/* 145 */       SettMarks.this.state++;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 150 */       if (this.active) {
/* 151 */         this.active = false;
/* 152 */         SettMarks.this.state++;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 158 */       file.bool(this.active);
/* 159 */       file.i(this.tile.x());
/* 160 */       file.i(this.tile.y());
/*     */       
/* 162 */       this.color.save(file);
/* 163 */       this.name.save(file);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 169 */       this.active = file.bool();
/* 170 */       this.tile.set(file.i(), file.i());
/* 171 */       this.color.load(file);
/* 172 */       this.name.load(file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 177 */       this.active = false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\SettMarks.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */