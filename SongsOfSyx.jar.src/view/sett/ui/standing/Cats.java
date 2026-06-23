/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.data.GETTER;
/*     */ import util.gui.table.GScrollRows;
/*     */ import view.interrupter.ISidePanel;
/*     */ 
/*     */ final class Cats
/*     */ {
/*  20 */   public final ArrayList<Cat> all = new ArrayList(STATS.COLLECTIONS().size());
/*     */   
/*  22 */   private ISidePanel[] panels = new ISidePanel[STATS.COLLECTIONS().size()];
/*     */ 
/*     */ 
/*     */   
/*     */   final Cat access;
/*     */ 
/*     */ 
/*     */   
/*     */   private final HCLASS cl;
/*     */ 
/*     */ 
/*     */   
/*     */   private final GETTER<Race> race;
/*     */ 
/*     */ 
/*     */   
/*     */   private int updateI;
/*     */ 
/*     */ 
/*     */   
/*     */   private double biggest;
/*     */ 
/*     */ 
/*     */   
/*     */   private void add(Cat p) {
/*  47 */     this.all.add(p); byte b; int i; StatCollection[] arrayOfStatCollection;
/*  48 */     for (i = (arrayOfStatCollection = p.cs).length, b = 0; b < i; ) { StatCollection c = arrayOfStatCollection[b];
/*  49 */       this.panels[c.index()] = p;
/*     */       b++; }
/*     */   
/*  52 */   } Cats(HCLASS cl, GETTER<Race> race) { this.updateI = -1;
/*  53 */     this.biggest = 0.0D; this.race = race; this.cl = cl; this.access = new CatAccess(cl, race); add(new CatPopulation(cl, race)); add(this.access); add(new CatServices(cl, race)); add(new CatEnv(cl, race)); add(new CatReligion(cl, race)); add(new CatOccupation(cl, race)); add(new CatGovern(cl, race)); for (StatCollection c : STATS.COLLECTIONS()) {
/*     */       if (this.panels[c.index()] == null && hasStanding(c))
/*     */         add(new CatDummy(cl, race, new StatCollection[] { c })); 
/*  56 */     }  } double getBiggest() { if (this.updateI == GAME.updateI()) {
/*  57 */       return this.biggest;
/*     */     }
/*  59 */     this.updateI = GAME.updateI();
/*  60 */     this.biggest = 0.0D;
/*     */     
/*  62 */     for (Cat ca : this.all) {
/*  63 */       double m = 0.0D; byte b; int i; StatCollection[] arrayOfStatCollection;
/*  64 */       for (i = (arrayOfStatCollection = ca.cs).length, b = 0; b < i; ) { StatCollection c = arrayOfStatCollection[b];
/*  65 */         for (STAT s : c.all())
/*  66 */           m += s.standing().max(this.cl, (Race)this.race.get()); 
/*     */         b++; }
/*     */       
/*  69 */       if (m > this.biggest)
/*  70 */         this.biggest = m; 
/*     */     } 
/*  72 */     return this.biggest; }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean hasStanding(StatCollection c) {
/*  77 */     for (STAT s : c.all()) {
/*  78 */       for (HCLASS cl : HCLASSES.ALL()) {
/*  79 */         for (Race r : RACES.all()) {
/*  80 */           if (s.standing().max(cl, r) > 0.0D) {
/*  81 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   static class Cat
/*     */     extends ISidePanel {
/*     */     final StatCollection[] cs;
/*     */     CharSequence name;
/*     */     CharSequence desc;
/*     */     
/*     */     Cat(StatCollection[] cs) {
/*  97 */       this.cs = cs;
/*  98 */       titleSet((cs[0]).info.name);
/*  99 */       this.name = (cs[0]).info.name;
/* 100 */       this.desc = (cs[0]).info.name;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class CatDummy
/*     */     extends Cat
/*     */   {
/*     */     CatDummy(HCLASS cl, GETTER<Race> race, StatCollection... cs) {
/* 108 */       super(cs);
/* 109 */       titleSet((cs[0]).info.name);
/*     */ 
/*     */       
/* 112 */       LinkedList<RENDEROBJ> rens = new LinkedList(); byte b; int i;
/*     */       StatCollection[] arrayOfStatCollection;
/* 114 */       for (i = (arrayOfStatCollection = cs).length, b = 0; b < i; ) { StatCollection c = arrayOfStatCollection[b];
/* 115 */         rens.add(new StatRow.Title(c.info));
/* 116 */         for (STAT s : c.all()) {
/* 117 */           rens.add(new StatRow(s, cl, race));
/*     */         }
/*     */         
/*     */         b++; }
/*     */       
/* 122 */       this.section.add((RENDEROBJ)(new GScrollRows((Iterable)rens, HEIGHT, 0)).view());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\Cats.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */