/*     */ package settlement.tilemap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.ShortCoo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
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
/*     */ public final class SettMark
/*     */   implements SAVABLE
/*     */ {
/* 100 */   public final ShortCoo tile = new ShortCoo();
/* 101 */   public final ColorImp color = new ColorImp();
/* 102 */   public final Str name = new Str(20);
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean active;
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosition(int position) {
/* 111 */     int i = 0;
/* 112 */     for (SettMark d : SettMarks.this.active()) {
/* 113 */       if (i == position) {
/* 114 */         if (d == this)
/*     */           return; 
/* 116 */         if (!d.active)
/*     */           return; 
/* 118 */         SettMarks.this.state++;
/* 119 */         int tx = d.tile.x();
/* 120 */         int ty = d.tile.y();
/* 121 */         ColorImp.TMP.set((COLOR)d.color);
/* 122 */         Str.TMP.clear().add((CharSequence)d.name);
/*     */         
/* 124 */         d.tile.set((COORDINATE)this.tile);
/* 125 */         d.color.set((COLOR)this.color);
/* 126 */         d.name.clear().add((CharSequence)this.name);
/*     */         
/* 128 */         this.tile.set(tx, ty);
/* 129 */         this.color.set((COLOR)ColorImp.TMP);
/* 130 */         this.name.clear().add((CharSequence)Str.TMP);
/*     */       } 
/* 132 */       if (d.active) {
/* 133 */         i++;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int tx, int ty) {
/* 140 */     this.active = true;
/* 141 */     this.tile.set(tx, ty);
/* 142 */     this.color.set(RND.rInt(127), RND.rInt(127), RND.rInt(127));
/*     */     
/* 144 */     this.name.clear().add('?');
/* 145 */     SettMarks.this.state++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove() {
/* 150 */     if (this.active) {
/* 151 */       this.active = false;
/* 152 */       SettMarks.this.state++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 158 */     file.bool(this.active);
/* 159 */     file.i(this.tile.x());
/* 160 */     file.i(this.tile.y());
/*     */     
/* 162 */     this.color.save(file);
/* 163 */     this.name.save(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 169 */     this.active = file.bool();
/* 170 */     this.tile.set(file.i(), file.i());
/* 171 */     this.color.load(file);
/* 172 */     this.name.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 177 */     this.active = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\SettMarks$SettMark.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */