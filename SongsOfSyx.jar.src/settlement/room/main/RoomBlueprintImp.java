/*     */ package settlement.room.main;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.Ambiance;
/*     */ import game.audio.SoundRace;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.type.CLIMATE;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.info.INFO;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RoomBlueprintImp
/*     */   extends RoomBlueprint
/*     */ {
/*     */   public final Icon icon;
/*     */   public final String type;
/*     */   public final INFO info;
/*     */   public final RoomCategorySub cat;
/*     */   protected double degradeRate;
/*     */   private final RoomUpgrades upgrades;
/*     */   private final int typeIndex;
/*     */   public final Lockable<Faction> reqs;
/*     */   public final Ambiance soundAmbiance;
/*     */   public final SoundRace clickSounds;
/*     */   protected Boostable bonus;
/*  42 */   static ArrayListResize<RoomBlueprintImp> IMPS = new ArrayListResize(10, 512);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected RoomBlueprintImp(RoomInitData init, int typeIndex, String key, RoomCategorySub cat) throws IOException {
/*  53 */     this(init, typeIndex, key, cat, (ACTION)null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected RoomBlueprintImp(RoomInitData init, int typeIndex, String key, RoomCategorySub cat, ACTION wiki) throws IOException {
/*  58 */     super(key);
/*  59 */     init.init(key);
/*  60 */     this.typeIndex = typeIndex;
/*  61 */     if (cat != null)
/*  62 */       cat.add(this); 
/*  63 */     this.type = init.type();
/*  64 */     this.info = new INFO(init.text(), wiki);
/*  65 */     this.icon = icon(init);
/*  66 */     this.cat = cat;
/*  67 */     if (init.data().has("DEGRADE_RATE")) {
/*  68 */       this.degradeRate = init.data().d("DEGRADE_RATE", 0.0D, 1.0D);
/*     */     } else {
/*  70 */       this.degradeRate = 0.75D;
/*  71 */     }  this.upgrades = new RoomUpgrades(this, init);
/*  72 */     IMPS.add(this);
/*  73 */     this.reqs = GVALUES.FACTION.LOCK.push("ROOM_" + key, this.info.name, this.info.desc, (SPRITE)this.icon);
/*  74 */     this.reqs.push(init.data());
/*  75 */     this.soundAmbiance = AUDIO.AMBI().get("ROOM_" + key);
/*  76 */     this.clickSounds = AUDIO.race("ROOM_CLICK_" + key);
/*     */   }
/*     */   
/*     */   private Icon icon(RoomInitData init) throws IOException {
/*  80 */     return SPRITES.icons().get(init.data());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Boostable bonus() {
/*  86 */     return this.bonus;
/*     */   }
/*     */   
/*     */   public Icon iconBig() {
/*  90 */     return this.icon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract SFinderFindable service(int paramInt1, int paramInt2);
/*     */ 
/*     */   
/*     */   public COLOR miniC(int tx, int ty) {
/*  99 */     return constructor().miniColor(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniCPimped(ColorImp origional, int tx, int ty, boolean northern, boolean southern) {
/* 104 */     return constructor().miniColorPimped(origional, tx, ty, northern, southern);
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract Furnisher constructor();
/*     */   
/*     */   public boolean isAvailable(CLIMATE c) {
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double degradeRate() {
/* 117 */     return this.degradeRate;
/*     */   }
/*     */   
/*     */   public RoomUpgrades upgrades() {
/* 121 */     return this.upgrades;
/*     */   }
/*     */   
/*     */   public int typeIndex() {
/* 125 */     return this.typeIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     return "[" + index() + "]" + this.key;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomBlueprintImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */