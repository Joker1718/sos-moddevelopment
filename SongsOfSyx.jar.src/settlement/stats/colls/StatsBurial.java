/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.spirit.grave.GraveData;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import settlement.stats.stat.STATFakeRace;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatHoverer;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapInt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ public class StatsBurial
/*     */   extends StatCollection
/*     */ {
/*     */   private final LIST<StatGrave> graves;
/*     */   public STAT DESECRATION;
/*     */   private final LIST<STAT> others;
/*  40 */   private static CharSequence ¤¤more = "¤We want better prospects of being buried in a {0}.";
/*  41 */   private static CharSequence ¤¤less = "¤We do not wish to be buried in a {0}.";
/*  42 */   private static CharSequence ¤¤name = "Burial";
/*  43 */   private static CharSequence ¤¤desc = "Stats related to afterlife.";
/*     */ 
/*     */   
/*     */   static {
/*  47 */     D.ts(StatsBurial.class);
/*     */   }
/*     */   
/*     */   public StatsBurial(StatsInit init) {
/*  51 */     super(init, "BURIAL", ¤¤name, ¤¤desc);
/*     */     
/*  53 */     final ArrayList<StatGrave> graves = new ArrayList((SETT.ROOMS()).GRAVES.size());
/*  54 */     for (GraveData.GRAVE_DATA_HOLDER h : (SETT.ROOMS()).GRAVES) {
/*  55 */       StatInfo in = new StatInfo((h.graveData().blueprint()).info.names, (h.graveData().blueprint()).info.desc);
/*  56 */       in.setOpinion(¤¤more, ¤¤less);
/*     */       
/*  58 */       graves.add(new StatGrave(h.graveData(), init, in));
/*     */     } 
/*  60 */     this.graves = (LIST<StatGrave>)graves;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     this.DESECRATION = (STAT)new STATFakeRace("DESECRATION", init)
/*     */       {
/*     */         protected double getDD(Race r)
/*     */         {
/*  69 */           double am = 0.0D;
/*  70 */           for (StatsBurial.StatGrave g : graves)
/*  71 */             am += (g.grave()).disturbance.getD(); 
/*  72 */           return am;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  77 */     ArrayList<STAT> others = new ArrayList(all().size());
/*  78 */     for (STAT s : all()) {
/*  79 */       if (s instanceof StatGrave)
/*     */         continue; 
/*  81 */       others.add(s);
/*     */     } 
/*  83 */     this.others = (LIST<STAT>)new ArrayList((Iterable)others);
/*     */ 
/*     */     
/*  86 */     init.upers.add(new GraveUpdater());
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<STAT> others() {
/*  91 */     return this.others;
/*     */   }
/*     */   
/*     */   public LIST<StatGrave> graves() {
/*  95 */     return this.graves;
/*     */   }
/*     */   private class GraveUpdater implements StatsInit.StatUpdatable { private int[] available;
/*     */     
/*     */     private GraveUpdater() {
/* 100 */       this.available = Alloc.ii(StatsBurial.this.graves.size());
/* 101 */       this.needed = Alloc.ii(StatsBurial.this.graves.size());
/*     */     }
/*     */     private int[] needed;
/*     */     
/*     */     public void update(double ds) {
/* 106 */       for (StatsBurial.StatGrave gr : StatsBurial.this.graves) {
/* 107 */         this.available[gr.gIndex()] = (gr.grave()).total.get(null) * 100;
/*     */       }
/*     */       
/* 110 */       for (HCLASS c : HCLASSES.ALL()) {
/* 111 */         if (!c.player) {
/*     */           continue;
/*     */         }
/* 114 */         for (StatsBurial.StatGrave gr : StatsBurial.this.graves) {
/* 115 */           this.needed[gr.gIndex()] = 0;
/*     */         }
/*     */         
/* 118 */         for (Race r : RACES.all()) {
/* 119 */           for (StatsBurial.StatGrave gr : (r.service()).GRAVES.get(c.index())) {
/* 120 */             if (gr.grave().permission().get(c, r)) {
/* 121 */               this.needed[gr.gIndex()] = this.needed[gr.gIndex()] + POP.tot(c, r);
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 126 */         for (Race r : RACES.all()) {
/* 127 */           for (StatsBurial.StatGrave gr : (r.service()).GRAVES.get(c.index())) {
/* 128 */             if (gr.grave().permission().get(c, r)) {
/* 129 */               gr.access.get((MAPPED)c).set((MAPPED)r, 0);
/*     */               
/* 131 */               int av = this.available[gr.gIndex()];
/* 132 */               int needed = this.needed[gr.gIndex()];
/* 133 */               if (av == 0) {
/* 134 */                 gr.access.get((MAPPED)c).setD(r, 0.0D); continue;
/*     */               } 
/* 136 */               double d = av / (needed + 1);
/* 137 */               gr.access.get((MAPPED)c).setD(r, CLAMP.d(d, 0.0D, 1.0D));
/*     */               
/*     */               continue;
/*     */             } 
/* 141 */             gr.access.get((MAPPED)c).setD(r, 0.0D);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class StatGrave
/*     */     extends STATFakeData
/*     */   {
/*     */     private GraveData h;
/*     */     
/* 154 */     private RMapInt.RMapIntTwo<HCLASS, Race> access = new RMapInt.RMapIntTwo(HCLASSES.MAP(), RACES.map());
/*     */     
/*     */     StatGrave(GraveData h, StatsInit init, StatInfo info) {
/* 157 */       super((h.blueprint()).key, "BURR_" + (h.blueprint()).key, init, info);
/* 158 */       this.standing = new StatStanding((STAT)this, 0.0D, h.standingDef());
/* 159 */       this.h = h;
/*     */ 
/*     */       
/* 162 */       init.savers.put("BURR_ACCESS_" + (h.blueprint()).key, this.access);
/* 163 */       (info()).icon = (h.blueprint()).icon.resized(16);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected double getDD(HCLASS cl, Race r) {
/* 169 */       return this.access.get((MAPPED)cl).getD(r) * (this.h.get(cl)).value.getD(r);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public GraveData grave() {
/* 175 */       return this.h;
/*     */     }
/*     */     
/*     */     int gIndex() {
/* 179 */       return index() - ((StatGrave)(STATS.BURIAL()).graves.get(0)).index();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 185 */       GBox b = (GBox)text;
/* 186 */       b.title((info()).name);
/* 187 */       GraveData da = grave();
/*     */       
/* 189 */       b.textLL(Dic.¤¤Access);
/* 190 */       b.add((SPRITE)GFORMAT.perc(b.text(), this.access.get((MAPPED)cl).getD(type)));
/*     */ 
/*     */       
/* 193 */       b.textLL((da.respect.info()).name);
/* 194 */       b.add((SPRITE)GFORMAT.perc(b.text(), da.respect.getD(null)));
/* 195 */       b.NL().text((da.respect.info()).desc);
/* 196 */       b.NL(4);
/* 197 */       b.textLL(((da.get(cl)).burried.info()).name);
/* 198 */       b.add((SPRITE)GFORMAT.iofkInv(b.text(), (int)(da.get(cl)).burried.getD(type), ((int)(da.get(cl)).burried.getD(type) + (int)(da.get(cl)).failed.getD(type))));
/*     */       
/* 200 */       b.NL().text(((da.get(cl)).burried.info()).desc);
/* 201 */       b.sep();
/* 202 */       StatHoverer.hover(text, (STAT)this, cl, type);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hover(GUI_BOX text, Induvidual indu) {
/* 207 */       hover(text, indu.clas(), indu.race());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsBurial.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */