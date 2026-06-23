/*     */ package game.faction;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.trade.FBUYER;
/*     */ import game.faction.trade.FSELLER;
/*     */ import init.race.Race;
/*     */ import init.trade.TRADABLE;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADArmies;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.Realm;
/*     */ 
/*     */ public abstract class Faction
/*     */   implements BOOSTABLE_O, INDEXED {
/*     */   boolean wasActive = false;
/*  30 */   public final Str name = new Str(24);
/*     */   private final int index;
/*     */   protected boolean event;
/*     */   public short eventMark;
/*     */   
/*     */   protected Faction(LISTE<Faction> all) {
/*  36 */     this.index = all.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Race race();
/*     */ 
/*     */   
/*     */   public final int index() {
/*  45 */     return this.index;
/*     */   }
/*     */   
/*     */   public final Region capitolRegion() {
/*  49 */     return RD.REALM(this).capitol();
/*     */   }
/*     */   
/*     */   protected void save(FilePutter file) {
/*  53 */     this.name.save(file);
/*  54 */     res().save(file);
/*  55 */     banner().save(file);
/*  56 */     credits().save(file);
/*  57 */     file.bool(this.wasActive);
/*  58 */     file.bool(this.event);
/*  59 */     file.s(this.eventMark);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  63 */     this.name.load(file);
/*  64 */     res().load(file);
/*  65 */     banner().load(file);
/*  66 */     credits().load(file);
/*  67 */     this.wasActive = file.bool();
/*  68 */     this.event = file.bool();
/*  69 */     this.eventMark = file.s();
/*     */   }
/*     */   
/*     */   protected void clear() {
/*  73 */     this.name.clear();
/*  74 */     res().clear();
/*  75 */     banner().clear();
/*  76 */     credits().clear();
/*  77 */     this.event = false;
/*  78 */     this.eventMark = 0;
/*     */   }
/*     */   
/*     */   protected void update(double ds) {
/*  82 */     res().update(ds, this);
/*  83 */     banner().update(ds, this);
/*  84 */     credits().update(ds, this);
/*     */   }
/*     */   
/*     */   public final boolean isActive() {
/*  88 */     return (realm().capitol() != null);
/*     */   }
/*     */   
/*     */   public int cx() {
/*  92 */     if (realm().regions() > 0)
/*  93 */       return realm().capitol().cx(); 
/*  94 */     if (armies().all().size() > 0)
/*  95 */       return ((WArmy)armies().all().get(0)).ctx(); 
/*  96 */     return WORLD.TWIDTH() / 2;
/*     */   }
/*     */   
/*     */   public int cy() {
/* 100 */     if (realm().regions() > 0)
/* 101 */       return realm().capitol().cy(); 
/* 102 */     if (armies().all().size() > 0)
/* 103 */       return ((WArmy)armies().all().get(0)).cty(); 
/* 104 */     return WORLD.THEIGHT() / 2;
/*     */   }
/*     */   
/*     */   public Realm realm() {
/* 108 */     return RD.REALM(this);
/*     */   }
/*     */   
/*     */   public abstract FBUYER buyer(TRADABLE paramTRADABLE);
/*     */   
/*     */   public abstract FSELLER seller(TRADABLE paramTRADABLE);
/*     */   
/*     */   public abstract FResources res();
/*     */   
/*     */   public abstract FBanner banner();
/*     */   
/*     */   public abstract FCredits credits();
/*     */   
/*     */   public ADArmies armies() {
/* 122 */     return AD.army(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract CharSequence rulerName();
/*     */ 
/*     */   
/*     */   public static abstract class FactionActivityListener
/*     */   {
/* 131 */     static final LinkedList<FactionActivityListener> all = new LinkedList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FactionActivityListener() {
/* 143 */       all.add(this);
/*     */     }
/*     */     
/*     */     public abstract void remove(FactionNPC param1FactionNPC);
/*     */     
/*     */     public abstract void add(FactionNPC param1FactionNPC);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 152 */     return "[" + this.index + "]" + String.valueOf(this.name);
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
/*     */   public double boostableValue(BValue v) {
/* 164 */     return v.vGet(this);
/*     */   }
/*     */   
/*     */   public static CharSequence name(Faction f) {
/* 168 */     if (f != null)
/* 169 */       return (CharSequence)f.name; 
/* 170 */     return Dic.¤¤Rebels;
/*     */   }
/*     */   
/*     */   public abstract double offensivePower();
/*     */   
/*     */   public abstract int citizens(Race paramRace);
/*     */   
/*     */   public boolean event() {
/* 178 */     return this.event;
/*     */   }
/*     */   
/*     */   public void eventSet(boolean e) {
/* 182 */     this.event = e;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\Faction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */