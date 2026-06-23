/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.data.GETTER;
/*     */ import util.gui.table.GScrollRows;
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
/*     */ class CatDummy
/*     */   extends Cats.Cat
/*     */ {
/*     */   CatDummy(HCLASS cl, GETTER<Race> race, StatCollection... cs) {
/* 108 */     super(cs);
/* 109 */     titleSet((cs[0]).info.name);
/*     */ 
/*     */     
/* 112 */     LinkedList<RENDEROBJ> rens = new LinkedList(); byte b; int i;
/*     */     StatCollection[] arrayOfStatCollection;
/* 114 */     for (i = (arrayOfStatCollection = cs).length, b = 0; b < i; ) { StatCollection c = arrayOfStatCollection[b];
/* 115 */       rens.add(new StatRow.Title(c.info));
/* 116 */       for (STAT s : c.all()) {
/* 117 */         rens.add(new StatRow(s, cl, race));
/*     */       }
/*     */       
/*     */       b++; }
/*     */     
/* 122 */     this.section.add((RENDEROBJ)(new GScrollRows((Iterable)rens, HEIGHT, 0)).view());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\Cats$CatDummy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */