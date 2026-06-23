/*     */ package game.faction;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.npc.UpdaterNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.faction.trade.ResourcePrices;
/*     */ import game.faction.trade.TradeManager;
/*     */ import game.time.TIME;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.updating.IUpdater;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public class FACTIONS
/*     */   extends GAME.GameResource
/*     */ {
/*     */   private static final int MAX = 64;
/*  36 */   private static final int NPCS_MAX = MAX() - 1;
/*     */   
/*     */   private static FACTIONS self;
/*     */   
/*  40 */   private final IUpdater updater = new IUpdater(MAX(), TIME.days().bitSeconds() / 4.0D)
/*     */     {
/*     */       protected void update(int i, double timeSinceLast)
/*     */       {
/*  44 */         if (((Faction)FACTIONS.this.all.get(i)).isActive()) {
/*  45 */           ((Faction)FACTIONS.this.all.get(i)).update(timeSinceLast);
/*     */         }
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  51 */   private final ArrayList<Faction> all = new ArrayList(MAX());
/*  52 */   private final ArrayList<FactionNPC> npcs = new ArrayList(MAX() - 1);
/*  53 */   private final ArrayList<FactionNPC> npcsActive = new ArrayList(MAX() - 1);
/*  54 */   private final ArrayList<Faction> active = new ArrayList(MAX());
/*     */   
/*     */   private boolean dirty = true;
/*     */   private final Player player;
/*     */   private final FactionResource npcManager;
/*     */   public final UpdaterNPC ncpUpdater;
/*     */   private FactionNPC otherFaction;
/*     */   private final ResourcePrices prices;
/*  62 */   private final FWorth worth = new FWorth();
/*     */   
/*     */   private DIP dip;
/*  65 */   private static CharSequence ¤¤sim = "Simulating factions";
/*  66 */   private static CharSequence ¤¤factionDestroyed = "The faction of {0} has been completely destroyed.";
/*  67 */   private static CharSequence ¤¤newFaction = "A new faction has emerged. They call themselves '{0}'.";
/*     */   
/*     */   static {
/*  70 */     D.ts(FACTIONS.class);
/*     */   }
/*     */   
/*     */   public FACTIONS() throws IOException {
/*  74 */     super("FACTIONS", false);
/*  75 */     self = this;
/*     */     
/*  77 */     this.player = new Player((LISTE)this.all);
/*  78 */     this.ncpUpdater = new UpdaterNPC();
/*  79 */     for (int i = 1; i < MAX(); i++) {
/*  80 */       this.npcs.add(new FactionNPC((LISTE)this.all, this.ncpUpdater));
/*     */     }
/*     */     
/*  83 */     this.otherFaction = (FactionNPC)this.npcs.get(0);
/*     */     
/*  85 */     this.npcManager = (FactionResource)new TradeManager(this);
/*  86 */     this.dip = new DIP(this);
/*     */ 
/*     */     
/*  89 */     FactionProfileFlusher.load(player());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     IDebugPanel.add("Factions Prime", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 103 */             FACTIONS.this.prime();
/*     */           }
/*     */         });
/*     */     
/* 107 */     this.prices = new ResourcePrices();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void activate(Faction f) {
/* 113 */     if (f == null || f == this.player)
/*     */       return; 
/* 115 */     boolean a = f.isActive();
/* 116 */     if (f.wasActive != a) {
/* 117 */       this.dirty = true;
/* 118 */       f.wasActive = a;
/* 119 */       if (a) {
/* 120 */         for (Faction.FactionActivityListener li : Faction.FactionActivityListener.all)
/* 121 */           li.add((FactionNPC)f); 
/*     */       } else {
/* 123 */         for (Faction.FactionActivityListener li : Faction.FactionActivityListener.all) {
/* 124 */           li.remove((FactionNPC)f);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void save(FilePutter file) {
/* 131 */     for (Faction f : this.all) {
/* 132 */       file.mark("" + f.index());
/* 133 */       f.save(file);
/* 134 */       file.mark("" + f.index());
/*     */     } 
/* 136 */     this.updater.save(file);
/* 137 */     this.npcManager.save(file);
/* 138 */     this.dip.save(file);
/* 139 */     file.i(this.otherFaction.index());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 145 */     for (Faction f : this.all) {
/* 146 */       file.check("" + f.index());
/* 147 */       f.load(file);
/* 148 */       file.check("" + f.index());
/*     */     } 
/* 150 */     this.updater.load(file);
/* 151 */     this.npcManager.load(file);
/* 152 */     this.dip.load(file);
/*     */     
/* 154 */     this.otherFaction = (FactionNPC)this.all.get(file.i());
/* 155 */     this.dirty = true;
/* 156 */     this.prices.clearCache();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/* 165 */     prof.logStart(this.updater.getClass());
/* 166 */     this.updater.update(ds);
/* 167 */     prof.logEnd(this.updater.getClass());
/*     */     
/* 169 */     prof.logStart(this.npcManager.getClass());
/* 170 */     this.npcManager.update(ds, null);
/* 171 */     prof.logEnd(this.npcManager.getClass());
/*     */     
/* 173 */     prof.logStart(this.player.getClass());
/* 174 */     this.player.updateSpecial(ds, prof);
/* 175 */     prof.logEnd(this.player.getClass());
/*     */     
/* 177 */     prof.logStart(this.dip.getClass());
/* 178 */     this.dip.update(ds, null);
/* 179 */     prof.logEnd(this.dip.getClass());
/*     */   }
/*     */   
/*     */   public static Player player() {
/* 183 */     return self.player;
/*     */   }
/*     */   
/*     */   public static Faction getByIndex(int index) {
/* 187 */     return (Faction)self.all.get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void prime() {
/* 204 */     SPRITES.loader().print(¤¤sim);
/*     */     
/* 206 */     int a = 50;
/*     */ 
/*     */ 
/*     */     
/* 210 */     for (int i = 0; i < a; i++) {
/* 211 */       SPRITES.loader().print(String.valueOf(¤¤sim) + ": " + String.valueOf(¤¤sim) + "%");
/*     */       
/* 213 */       for (FactionNPC f : NPCs()) {
/* 214 */         RD.UPDATER().shipAll((Faction)f, 1.0D);
/* 215 */         f.stockpile.update(f, TIME.secondsPerDay());
/*     */       } 
/*     */       
/* 218 */       if (i % 4 == 0) {
/* 219 */         ((TradeManager)self.npcManager).prime();
/*     */       }
/*     */     } 
/* 222 */     ((TradeManager)self.npcManager).prime();
/* 223 */     this.prices.clearCache();
/*     */   }
/*     */ 
/*     */   
/*     */   public static FactionNPC activateNext(Region capitol, RDRace prefRace, boolean log) {
/* 228 */     if (capitol.realm() != null) {
/* 229 */       throw new RuntimeException();
/*     */     }
/* 231 */     FactionNPC ff = self.free();
/* 232 */     if (ff == null)
/* 233 */       return null; 
/* 234 */     ff.clear();
/* 235 */     capitol.fationSet((Faction)ff, log);
/*     */     
/* 237 */     capitol.info.name().clear().add((CharSequence)ff.name);
/*     */     
/* 239 */     ff.generate(prefRace, true);
/*     */     
/* 241 */     for (Faction.FactionActivityListener li : Faction.FactionActivityListener.all)
/* 242 */       li.add(ff); 
/* 243 */     ((Faction)ff).wasActive = true;
/*     */     
/* 245 */     if (log && SETT.exists()) {
/* 246 */       Str.TMP.clear().add(¤¤newFaction);
/* 247 */       Str.TMP.insert(0, (CharSequence)ff.name);
/* 248 */       WORLD.LOG().log(null, (Faction)ff, (UI.icons()).s.crown, (CharSequence)Str.TMP, ff.cx(), ff.cy());
/*     */     } 
/*     */     
/* 251 */     return ff;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean canActivateNext() {
/* 256 */     return (self.free() != null);
/*     */   }
/*     */   
/*     */   public static int frees() {
/* 260 */     int am = 0;
/* 261 */     for (FactionNPC f : self.npcs) {
/* 262 */       if (!f.isActive()) {
/* 263 */         am++;
/*     */       }
/*     */     } 
/* 266 */     return am;
/*     */   }
/*     */   
/*     */   public FactionNPC free() {
/* 270 */     for (FactionNPC f : this.npcs) {
/* 271 */       if (!f.isActive()) {
/* 272 */         ((Faction)f).wasActive = false;
/* 273 */         return f;
/*     */       } 
/*     */     } 
/* 276 */     self.dirty = true;
/* 277 */     return null;
/*     */   }
/*     */   
/*     */   public static LIST<FactionNPC> NPCs() {
/* 281 */     active();
/* 282 */     return (LIST<FactionNPC>)self.npcsActive;
/*     */   }
/*     */ 
/*     */   
/*     */   public static LIST<Faction> active() {
/* 287 */     if (self.dirty) {
/* 288 */       self.active.clearSloppy();
/* 289 */       self.active.add(self.player);
/* 290 */       self.npcsActive.clearSloppy();
/* 291 */       self.dirty = false;
/* 292 */       for (int i = 0; i < self.npcs.size(); i++) {
/* 293 */         if (((FactionNPC)self.npcs.get(i)).realm().capitol() != null) {
/* 294 */           self.npcsActive.add(self.npcs.get(i));
/* 295 */           self.active.add(self.npcs.get(i));
/*     */         } 
/*     */       } 
/*     */     } 
/* 299 */     return (LIST<Faction>)self.active;
/*     */   }
/*     */   
/*     */   public static LIST<Faction> all() {
/* 303 */     return (LIST<Faction>)self.all;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void remove(FactionNPC faction, boolean log) {
/* 309 */     if (log) {
/* 310 */       Str.TMP.clear().add(¤¤factionDestroyed);
/* 311 */       Str.TMP.insert(0, (CharSequence)faction.name);
/* 312 */       WORLD.LOG().log(null, (Faction)faction, (UI.icons()).s.crown, (CharSequence)Str.TMP, faction.cx(), faction.cy());
/*     */     } 
/*     */     
/* 315 */     faction.armies().disbandAll();
/* 316 */     RD.clearFaction(faction);
/* 317 */     self.dirty = true;
/*     */   }
/*     */   
/*     */   public static void otherFactionSet(FactionNPC faction) {
/* 321 */     self.otherFaction = faction;
/*     */   }
/*     */   
/*     */   public static FactionNPC otherFaction() {
/* 325 */     return self.otherFaction;
/*     */   }
/*     */   
/*     */   public static CharSequence name(Faction f) {
/* 329 */     if (f == null)
/* 330 */       return Dic.¤¤Rebels; 
/* 331 */     return (CharSequence)f.name;
/*     */   }
/*     */   
/*     */   public static ResourcePrices PRICE() {
/* 335 */     return self.prices;
/*     */   }
/*     */   
/*     */   public static FWorth WORTH() {
/* 339 */     return self.worth;
/*     */   }
/*     */   
/*     */   public static int MAX() {
/* 343 */     return 64;
/*     */   }
/*     */   
/*     */   public static int NPC_MAX() {
/* 347 */     return NPCS_MAX;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FACTIONS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */