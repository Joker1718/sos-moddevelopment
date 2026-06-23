/*     */ package game.battle.div;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.data.DOUBLE;
/*     */ import util.text.Dic;
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
/*     */ class null
/*     */   implements SAVABLE
/*     */ {
/*     */   public void save(FilePutter file) {
/*     */     byte b;
/*     */     int i;
/*     */     DOUBLE.DoubleImp[] arrayOfDoubleImp;
/* 148 */     for (i = (arrayOfDoubleImp = DivInfo.this.trains).length, b = 0; b < i; ) { DOUBLE.DoubleImp t = arrayOfDoubleImp[b];
/* 149 */       t.save(file);
/*     */       
/*     */       b++; }
/*     */     
/* 153 */     file.i(DivInfo.this.menTarget);
/* 154 */     file.i(DivInfo.this.raceI);
/* 155 */     file.i(DivInfo.this.exMin);
/* 156 */     file.i(DivInfo.this.symbolI);
/* 157 */     DivInfo.this.name.save(file);
/*     */   } public void load(FileGetter file) throws IOException {
/*     */     byte b;
/*     */     int i;
/*     */     DOUBLE.DoubleImp[] arrayOfDoubleImp;
/* 162 */     for (i = (arrayOfDoubleImp = DivInfo.this.trains).length, b = 0; b < i; ) { DOUBLE.DoubleImp t = arrayOfDoubleImp[b];
/* 163 */       t.load(file); b++; }
/*     */     
/* 165 */     DivInfo.this.menTarget = file.i();
/* 166 */     DivInfo.this.raceI = file.i();
/* 167 */     DivInfo.this.exMin = file.i();
/* 168 */     DivInfo.this.symbolI = file.i();
/* 169 */     DivInfo.this.name.load(file);
/*     */   } public void clear() {
/*     */     byte b;
/*     */     int i;
/*     */     DOUBLE.DoubleImp[] arrayOfDoubleImp;
/* 174 */     for (i = (arrayOfDoubleImp = DivInfo.this.trains).length, b = 0; b < i; ) { DOUBLE.DoubleImp t = arrayOfDoubleImp[b];
/* 175 */       t.setD(0.0D); b++; }
/*     */     
/* 177 */     DivInfo.this.menTarget = 0;
/* 178 */     DivInfo.this.raceI = (FACTIONS.player().race()).index;
/* 179 */     DivInfo.this.exMin = 0;
/* 180 */     DivInfo.this.symbolI = DivInfo.this.div.index();
/* 181 */     DivInfo.this.name.clear().add(Dic.¤¤Division).add(' ').add('#').add(DivInfo.this.div.index());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\div\DivInfo$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */