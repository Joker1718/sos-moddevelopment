/*    */ package view.sett.ui.standing;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.BUILDING_PREF;
/*    */ import init.type.BUILDING_PREFS;
/*    */ import init.type.HCLASS;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.water.pool.ROOM_POOL;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsAccess;
/*    */ import settlement.stats.stat.STAT;
/*    */ import settlement.stats.stat.StatCollection;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.table.GScrollRows;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ final class CatEnv
/*    */   extends Cats.Cat {
/*    */   CatEnv(HCLASS cl, final GETTER<Race> race) {
/* 25 */     super(new StatCollection[] { (StatCollection)STATS.ENV(), (StatCollection)STATS.ACCESS(), (StatCollection)(STATS.ACCESS()).ACCESS, (StatCollection)(STATS.ACCESS()).MONUMENTS, (StatCollection)STATS.BATTLE(), (StatCollection)STATS.STORED() });
/* 26 */     titleSet((this.cs[0]).info.name);
/*    */     
/* 28 */     LinkedList<RENDEROBJ> rens = new LinkedList(); byte b; int i;
/*    */     StatCollection[] arrayOfStatCollection;
/* 30 */     for (i = (arrayOfStatCollection = this.cs).length, b = 0; b < i; ) { StatCollection c = arrayOfStatCollection[b];
/* 31 */       if (c.all().size() != 0)
/*    */       {
/* 33 */         if (c == (STATS.ACCESS()).MONUMENTS) {
/* 34 */           rens.add(new StatRow.Title(c.info));
/* 35 */           for (StatsAccess.StatMonument s : (STATS.ACCESS()).MONUMENTS.ALL()) {
/* 36 */             rens.add(new StatRow((STAT)s, cl, race));
/*    */           
/*    */           }
/*    */         }
/* 40 */         else if (c != STATS.STORED()) {
/* 41 */           rens.add(new StatRow.Title(c.info));
/* 42 */           for (STAT s : c.all()) {
/* 43 */             if (s == (STATS.ENV()).BUILDING_PREF) {
/* 44 */               rens.add(new StatRow(s, cl, race)
/*    */                   {
/*    */                     
/*    */                     public void hoverInfoGet(GUI_BOX text)
/*    */                     {
/* 49 */                       super.hoverInfoGet(text);
/* 50 */                       if (race.get() != null) {
/* 51 */                         GBox b = (GBox)text;
/* 52 */                         b.NL(8);
/* 53 */                         for (BUILDING_PREF p : BUILDING_PREFS.ALL()) {
/* 54 */                           b.add(p.icon());
/* 55 */                           b.add((SPRITE)GFORMAT.perc(b.text(), ((Race)race.get()).pref().structure(p)));
/*    */                         } 
/*    */                       }  }
/*    */                   });
/*    */               continue;
/*    */             } 
/* 61 */             if (s == (STATS.ENV()).POOL_PREF) {
/* 62 */               rens.add(new StatRow(s, cl, race)
/*    */                   {
/*    */                     
/*    */                     public void hoverInfoGet(GUI_BOX text)
/*    */                     {
/* 67 */                       super.hoverInfoGet(text);
/* 68 */                       if (race.get() != null) {
/* 69 */                         GBox b = (GBox)text;
/* 70 */                         b.NL(8);
/* 71 */                         for (ROOM_POOL p : (SETT.ROOMS()).POOLS) {
/* 72 */                           b.add((SPRITE)p.icon);
/* 73 */                           b.add((SPRITE)GFORMAT.perc(b.text(), ((Race)race.get()).pref().pool(p)));
/*    */                         } 
/*    */                       } 
/*    */                     }
/*    */                   });
/*    */               
/*    */               continue;
/*    */             } 
/* 81 */             if (s.info().matters())
/* 82 */               rens.add(new StatRow(s, cl, race)); 
/*    */           } 
/*    */         } 
/*    */       }
/*    */       b++; }
/*    */     
/* 88 */     rens.add(new StatRow.Title((STATS.STORED()).info));
/*    */     
/* 90 */     for (STAT s : STATS.STORED().createTheOnesThatMatter(cl)) {
/* 91 */       rens.add(new StatRow(s, cl, race));
/*    */     }
/*    */     
/* 94 */     this.section.addDown(4, (RENDEROBJ)(new GScrollRows((Iterable)rens, HEIGHT, 0)).view());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatEnv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */