/*     */ package init.type;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAPS;
/*     */ 
/*     */ public class HTYPE_RACE
/*     */   implements MAPPED
/*     */ {
/*     */   public final int index;
/*     */   public final HTYPE cl;
/*     */   public final Race race;
/*     */   
/*     */   HTYPE_RACE(int index, HTYPE cl, Race race) {
/*  20 */     this.index = index;
/*  21 */     this.cl = cl;
/*  22 */     this.race = race;
/*  23 */     this.key = ((cl == null) ? "NULL" : cl.key) + "_" + ((cl == null) ? "NULL" : cl.key);
/*     */   }
/*     */   private final String key; private static RClasses all; private static RMAPS<HTYPE_RACE> MAP;
/*     */   
/*     */   public int index() {
/*  28 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/*  33 */     return this.key;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  38 */     return "HTYPE_RACE : " + String.valueOf(this.cl) + " " + String.valueOf(this.race);
/*     */   }
/*     */   
/*     */   public static HTYPE_RACE get() {
/*  42 */     return all.classes[0][0];
/*     */   }
/*     */   
/*     */   public static HTYPE_RACE get(Induvidual i) {
/*  46 */     return get(i.race(), i.hType());
/*     */   }
/*     */   
/*     */   public static HTYPE_RACE get(Race race) {
/*  50 */     int ci = 0;
/*  51 */     int ri = (race == null) ? 0 : (race.index + 1);
/*  52 */     return all.classes[ci][ri];
/*     */   }
/*     */ 
/*     */   
/*     */   public static HTYPE_RACE get(HTYPE clas) {
/*  57 */     int ci = (clas == null) ? 0 : (clas.index() + 1);
/*  58 */     int ri = 0;
/*  59 */     return all.classes[ci][ri];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static HTYPE_RACE get(Race race, HTYPE clas) {
/*  65 */     int ci = (clas == null) ? 0 : (clas.index() + 1);
/*  66 */     int ri = (race == null) ? 0 : (race.index + 1);
/*  67 */     return all.classes[ci][ri];
/*     */   }
/*     */   
/*     */   public static RMAPS<HTYPE_RACE> MAP() {
/*  71 */     return MAP;
/*     */   }
/*     */   
/*     */   public static LIST<HTYPE_RACE> ALL() {
/*  75 */     return all.all;
/*     */   }
/*     */   
/*     */   public static LIST<HTYPE_RACE> ALL_REAL() {
/*  79 */     return all.allReal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void init(HTYPES cl, RACES races) {
/*  86 */     all = new RClasses(RACES.all(), HTYPES.ALL());
/*  87 */     ArrayListGrower<HTYPE_RACE> pps = new ArrayListGrower();
/*  88 */     for (HTYPE_RACE p : all.all) {
/*  89 */       if (p.cl != null && p.race != null)
/*  90 */         pps.add(p); 
/*  91 */     }  MAP = new RMAPS("PHTYPE_RACE", (LIST)pps);
/*     */   }
/*     */   
/*     */   private static final class RClasses
/*     */   {
/*     */     private final LIST<HTYPE_RACE> all;
/*     */     private final LIST<HTYPE_RACE> allReal;
/*     */     private final HTYPE_RACE[][] classes;
/*     */     
/*     */     RClasses(LIST<Race> races, LIST<HTYPE> types) {
/* 101 */       this.classes = new HTYPE_RACE[types.size() + 1][races.size() + 1];
/* 102 */       ArrayList<HTYPE_RACE> all = new ArrayList((races.size() + 1) * (types.size() + 1));
/* 103 */       ArrayList<HTYPE_RACE> real = new ArrayList(races.size() * types.size());
/* 104 */       for (Race r : races) {
/* 105 */         for (HTYPE cl : types) {
/* 106 */           HTYPE_RACE hTYPE_RACE = new HTYPE_RACE(all.size(), cl, r);
/* 107 */           all.add(hTYPE_RACE);
/* 108 */           real.add(hTYPE_RACE);
/*     */         } 
/*     */       } 
/* 111 */       for (Race r : races) {
/* 112 */         all.add(new HTYPE_RACE(all.size(), null, r));
/*     */       }
/* 114 */       for (HTYPE cl : types) {
/* 115 */         HTYPE_RACE hTYPE_RACE = new HTYPE_RACE(all.size(), cl, null);
/* 116 */         all.add(hTYPE_RACE);
/*     */       } 
/* 118 */       HTYPE_RACE t = new HTYPE_RACE(all.size(), null, null);
/* 119 */       all.add(t);
/*     */       
/* 121 */       for (HTYPE_RACE tt : all) {
/* 122 */         int ci = (tt.cl == null) ? 0 : (tt.cl.index() + 1);
/* 123 */         int ri = (tt.race == null) ? 0 : (tt.race.index + 1);
/* 124 */         this.classes[ci][ri] = tt;
/*     */       } 
/*     */ 
/*     */       
/* 128 */       this.all = (LIST<HTYPE_RACE>)all;
/* 129 */       this.allReal = (LIST<HTYPE_RACE>)real;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HTYPE_RACE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */