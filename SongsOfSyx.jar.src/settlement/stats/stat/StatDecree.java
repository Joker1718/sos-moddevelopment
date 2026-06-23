/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.INT_O;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAPS;
/*     */ import util.keymap.RMapInt;
/*     */ 
/*     */ public class StatDecree
/*     */   extends StatInfo {
/*  19 */   private final RMapInt.RMapIntTwo<HCLASS, Race> levels = new RMapInt.RMapIntTwo<HCLASS, Race>(HCLASSES.MAP(), RACES.map())
/*     */     {
/*     */       public void clear() {
/*  22 */         super.clear();
/*  23 */         setAll(StatDecree.this.def);
/*     */       }
/*     */     };
/*     */   private final int def;
/*     */   private final ArrayList<INT_O.INT_OE<Race>> tars;
/*     */   
/*     */   public StatDecree(String dkey, StatsInit i, final int min, int max, int fractions, CharSequence name, int def) {
/*  30 */     super(name, "");
/*  31 */     this.def = def;
/*  32 */     i.savers.put(dkey + "_DEC", this.levels);
/*  33 */     this.levels.setAll(def);
/*  34 */     this.tars = new ArrayList(HCLASSES.ALL().size());
/*     */     
/*  36 */     final int m = max * fractions;
/*  37 */     this.ii = 1.0D / m;
/*  38 */     this.iii = 1.0D / fractions;
/*  39 */     for (HCLASS c : HCLASSES.ALL()) {
/*  40 */       this.tars.add(new INT_O.INT_OE<Race>()
/*     */           {
/*     */             public int min(Race t)
/*     */             {
/*  44 */               return min;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max(Race t) {
/*  49 */               return m;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get(Race t) {
/*  54 */               if (t == null) {
/*  55 */                 int m = 0;
/*  56 */                 for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  57 */                   Race r = (Race)RACES.all().get(ri);
/*  58 */                   m = Math.max(m, get(r));
/*     */                 } 
/*  60 */                 return m;
/*     */               } 
/*  62 */               return CLAMP.i(StatDecree.this.levels.get((MAPPED)c).get((MAPPED)t), min, m);
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(Race t, int i) {
/*  67 */               if (t == null) {
/*  68 */                 for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  69 */                   Race r = (Race)RACES.all().get(ri);
/*  70 */                   set(r, i);
/*     */                 } 
/*     */                 return;
/*     */               } 
/*  74 */               StatDecree.this.levels.get((MAPPED)c).set((MAPPED)t, CLAMP.i(i, min, m));
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private final double ii;
/*     */   
/*     */   private final double iii;
/*     */ 
/*     */   
/*     */   public INT_O.INT_OE<Race> getI(HCLASS c) {
/*  87 */     return (INT_O.INT_OE<Race>)this.tars.get(c.index());
/*     */   }
/*     */   
/*     */   public double getD(HCLASS c, Race race) {
/*  91 */     return ((INT_O.INT_OE)this.tars.get(c.index())).get(race) * this.ii;
/*     */   }
/*     */   
/*     */   public double get(HCLASS c, Race race) {
/*  95 */     return ((INT_O.INT_OE)this.tars.get(c.index())).get(race) * this.iii;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(Humanoid h) {
/* 100 */     double d = ((INT_O.INT_OE)this.tars.get(h.indu().clas().index())).get(h.indu().race()) * this.iii;
/* 101 */     int i = (int)d;
/* 102 */     if (RND.rFloat() < d - i)
/* 103 */       i++; 
/* 104 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\StatDecree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */