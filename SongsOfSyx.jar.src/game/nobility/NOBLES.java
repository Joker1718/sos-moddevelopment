/*     */ package game.nobility;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.BoostCompound;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.updating.IUpdater;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ public final class NOBLES
/*     */   extends GAME.GameResource {
/*  50 */   public static int MAX_MAX = 256;
/*     */   
/*     */   public final CharSequence[] nameRanks;
/*     */   
/*     */   public static final int RANK_INCREASE = 2;
/*  55 */   private final ArrayList<Noble> active = new ArrayList(256);
/*  56 */   private final ArrayList<Noble> all = new ArrayList(256);
/*     */   
/*     */   private final IUpdater upper;
/*     */   
/*     */   public final BoostSpecs boosters;
/*     */   public final Boostable MAX;
/*     */   public final Boostable MAX_RANKS;
/*     */   final BoostCompound<NobleOffice> bos;
/*  64 */   public final LIST<NobleOffice> OFFICES = NobleOfficeUtil.make();
/*     */ 
/*     */ 
/*     */   
/*  68 */   private int ranksAllocated = 0;
/*  69 */   private int[] allocations = Alloc.ii(this.OFFICES.size());
/*  70 */   private int ri = -1;
/*     */   
/*     */   public NOBLES() {
/*  73 */     super("NOBILITIES", false);
/*  74 */     D.t(this);
/*  75 */     this.MAX = BOOSTING.push("NOBLES_MAX", 0.0D, (HCLASSES.NOBLE()).names, D.g("desc", "The amount of nobles you may appoint."), (SPRITE)(UI.icons()).s.noble, (BoostableCat)BOOSTABLES.CIVICS());
/*  76 */     this.MAX_RANKS = BOOSTING.push("NOBLES_RANKS_MAX", 0.0D, D.g("rname", "Noble Promotions"), D.g("rdesc", "The amount of promotions you can offer your nobles."), (SPRITE)(UI.icons()).s.noble.twin((SPRITE)(UI.icons()).s.chevron(DIR.N).createColored(COLOR.ORANGE100), DIR.C, 0), (BoostableCat)BOOSTABLES.CIVICS());
/*  77 */     this.boosters = new BoostSpecs((HCLASSES.NOBLE()).names, (SPRITE)(UI.icons()).s.noble, true);
/*  78 */     this.nameRanks = (CharSequence[])(new Json((PATHS.PLAYER().folder("noble")).text.gets("_RANKS"))).texts("RANKS");
/*  79 */     while (this.all.hasRoom());
/*     */ 
/*     */     
/*  82 */     this.upper = new IUpdater(this.all.size(), 10.0D)
/*     */       {
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/*  86 */           ((Noble)NOBLES.this.all.get(i)).update(timeSinceLast);
/*     */         }
/*     */       };
/*     */     
/*  90 */     this.bos = new BoostCompound<NobleOffice>(this.boosters, this.OFFICES)
/*     */       {
/*     */ 
/*     */         
/*     */         protected BoostSpecs bos(NobleOffice t)
/*     */         {
/*  96 */           return t.boosts;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double get(Boostable bo, FactionNPC f, boolean isMul) {
/* 101 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(NobleOffice t) {
/* 106 */           return t.value(NOBLES.this.allocations(t));
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     IDebugPanel.add("noble galore", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 118 */             (new BoosterValue(BValue.VALUE1, new BSourceInfo("cheat", (SPRITE)(UI.icons()).s.cancel), 10.0D, false)).add(NOBLES.this.MAX);
/* 119 */             (new BoosterValue(BValue.VALUE1, new BSourceInfo("cheat", (SPRITE)(UI.icons()).s.cancel), 10.0D, false)).add(NOBLES.this.MAX_RANKS);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 128 */     for (Noble n : this.all)
/* 129 */       n.saver.save(file); 
/* 130 */     this.upper.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 135 */     for (Noble n : this.all)
/* 136 */       n.saver.load(file); 
/* 137 */     this.upper.load(file);
/* 138 */     this.bos.clearChache();
/* 139 */     this.ri = -1;
/* 140 */     this.active.clear();
/* 141 */     for (Noble n : this.all) {
/* 142 */       if (n.subject() != null) {
/* 143 */         this.active.add(n);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/* 149 */     prof.logStart(NOBLES.class);
/* 150 */     this.upper.update(ds);
/* 151 */     prof.logEnd(NOBLES.class);
/*     */   }
/*     */   
/*     */   public LIST<Noble> ALL() {
/* 155 */     return (LIST<Noble>)this.all;
/*     */   }
/*     */   
/*     */   public int maxRanks() {
/* 159 */     return this.nameRanks.length;
/*     */   }
/*     */   
/*     */   private void cache() {
/* 163 */     if (this.ri != this.active.size()) {
/* 164 */       this.ri = this.active.size();
/* 165 */       this.ranksAllocated = 0;
/* 166 */       Arrays.fill(this.allocations, 0);
/* 167 */       for (int ni = 0; ni < this.active.size(); ni++) {
/* 168 */         this.ranksAllocated += ((Noble)this.active.get(ni)).rank();
/* 169 */         NobleOffice n = ((Noble)this.active.get(ni)).office();
/* 170 */         if (n != null)
/* 171 */           this.allocations[n.index] = this.allocations[n.index] + 1 + 2 * ((Noble)this.active.get(ni)).rank(); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int ranksAllocated() {
/* 177 */     cache();
/* 178 */     return this.ranksAllocated;
/*     */   }
/*     */   
/*     */   public int allocations(NobleOffice o) {
/* 182 */     cache();
/* 183 */     return this.allocations[o.index];
/*     */   }
/*     */   
/*     */   public void ranksAllocate(Noble n) {
/* 187 */     if (ranksAllocated() < (int)this.MAX_RANKS.get((BOOSTABLE_O)HCLASS_RACE.clP())) {
/* 188 */       n.rankInc();
/* 189 */       this.ri = -1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public short assignOnlyCallFromHumanoid(Humanoid h) {
/* 194 */     if (!this.active.hasRoom())
/* 195 */       return -1; 
/* 196 */     for (Noble n : this.all) {
/* 197 */       if (n.subject() == null) {
/* 198 */         n.assign(h);
/* 199 */         this.bos.clearChache();
/* 200 */         this.ri = -1;
/* 201 */         if (this.active.contains(n))
/* 202 */           throw new RuntimeException(); 
/* 203 */         this.active.add(n);
/* 204 */         return n.index;
/*     */       } 
/*     */     } 
/* 207 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void vacateOnlyCallFromHumanoid(Humanoid h, short pos) {
/* 213 */     Noble e = (Noble)this.all.get(pos);
/* 214 */     if (e.subject() != h)
/* 215 */       throw new RuntimeException(); 
/* 216 */     DeathMess m = new DeathMess(h, e);
/* 217 */     this.active.remove(e);
/*     */     
/* 219 */     e.saver.clear();
/* 220 */     this.ri = -1;
/* 221 */     this.bos.clearChache();
/* 222 */     m.send();
/*     */   }
/*     */   
/*     */   public void setOffice(Noble n, NobleOffice office) {
/* 226 */     n.setOffice(office);
/* 227 */     this.ri = -1;
/*     */   }
/*     */   
/*     */   public Noble get(short index) {
/* 231 */     return (Noble)this.all.get(index);
/*     */   }
/*     */   
/*     */   public LIST<Noble> active() {
/* 235 */     return (LIST<Noble>)this.active;
/*     */   }
/*     */   
/* 238 */   private static CharSequence ¤¤title = "Nobility passed!";
/* 239 */   private static CharSequence ¤¤mess = "It is a sad day. {0} {1}, {2}, passed today. We can now assign a new nobleman to this cause.";
/* 240 */   private static CharSequence ¤¤messNo = "It is a sad day. {0} {1} passed today.";
/* 241 */   private static CharSequence ¤¤replace = "Replace";
/* 242 */   private static CharSequence ¤¤replaceD = "Automatically replace this noble, including rank and office, with a willing citizen.";
/*     */   
/*     */   static {
/* 245 */     D.ts(NOBLES.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class DeathMess
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final Induvidual indu;
/*     */     private final int no;
/*     */     private final int ranks;
/*     */     private String text;
/*     */     private boolean replaced = false;
/*     */     
/*     */     public DeathMess(Humanoid h, Noble n) {
/* 261 */       super(NOBLES.¤¤title);
/* 262 */       this.indu = new Induvidual(h.indu().hType(), h.race());
/* 263 */       this.indu.copyFromHard(h.indu());
/* 264 */       (STATS.APPEARANCE()).dead.indu().set(this.indu, 1);
/* 265 */       this.no = (n.office() == null) ? -1 : (n.office()).index;
/* 266 */       this.ranks = n.rank();
/* 267 */       if (this.no >= 0) {
/* 268 */         Str.TMP.clear().add(NOBLES.¤¤mess);
/* 269 */         Str.TMP.insert(0, n.rankName());
/* 270 */         Str.TMP.insert(1, STATS.APPEARANCE().name(h.indu()));
/* 271 */         Str.TMP.insert(2, n.title());
/*     */       } else {
/* 273 */         Str.TMP.clear().add(NOBLES.¤¤messNo);
/* 274 */         Str.TMP.insert(0, n.rankName());
/* 275 */         Str.TMP.insert(1, STATS.APPEARANCE().name(h.indu()));
/*     */       } 
/* 277 */       this.text = String.valueOf(Str.TMP);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 285 */       paragraph(this.text);
/*     */       
/* 287 */       section.addRelBody(8, DIR.N, (SPRITE)new SPRITE.Imp(160, 256)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/* 291 */               STATS.APPEARANCE().portraitRender(r, NOBLES.DeathMess.this.indu, X1, Y1, 4);
/*     */             }
/*     */           });
/*     */       
/* 295 */       if (this.no >= 0) {
/* 296 */         GButt.ButtPanel b = new GButt.ButtPanel(NOBLES.¤¤replace)
/*     */           {
/*     */ 
/*     */ 
/*     */             
/*     */             protected void renAction()
/*     */             {
/* 303 */               activeSet((!NOBLES.DeathMess.this.replaced && (GAME.NOBLE()).active.size() < (GAME.NOBLE()).MAX.get((BOOSTABLE_O)HCLASS_RACE.clP())));
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 308 */               if (NOBLES.DeathMess.this.replaced || (GAME.NOBLE()).active.size() >= (GAME.NOBLE()).MAX.get((BOOSTABLE_O)HCLASS_RACE.clP()))
/*     */                 return; 
/* 310 */               NOBLES.DeathMess.this.replaced = true; byte b; int i;
/*     */               ENTITY[] arrayOfENTITY;
/* 312 */               for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 313 */                 if (e instanceof Humanoid) {
/* 314 */                   Humanoid a = (Humanoid)e;
/* 315 */                   if (a.race() == NOBLES.DeathMess.this.indu.race() && a.indu().clas() == HCLASSES.CITIZEN()) {
/* 316 */                     NobleOffice o = (NobleOffice)(GAME.NOBLE()).OFFICES.get(NOBLES.DeathMess.this.no);
/* 317 */                     a.nobleSet();
/* 318 */                     GAME.NOBLE().setOffice(a.noble(), o);
/* 319 */                     for (int j = 0; j < NOBLES.DeathMess.this.ranks; j++) {
/* 320 */                       if (GAME.NOBLE().ranksAllocated() < (GAME.NOBLE()).MAX_RANKS.get((BOOSTABLE_O)HCLASS_RACE.clP()))
/* 321 */                         GAME.NOBLE().ranksAllocate(a.noble()); 
/*     */                     } 
/* 323 */                     VIEW.messages().hide();
/*     */                     
/*     */                     return;
/*     */                   } 
/*     */                 } 
/*     */                 
/*     */                 b++; }
/*     */             
/*     */             }
/*     */           };
/*     */         
/* 334 */         b.hoverInfoSet(NOBLES.¤¤replaceD);
/*     */         
/* 336 */         section.addRelBody(8, DIR.S, (RENDEROBJ)b);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\nobility\NOBLES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */