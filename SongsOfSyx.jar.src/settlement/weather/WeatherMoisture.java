/*     */ package settlement.weather;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ public final class WeatherMoisture
/*     */   extends WeatherThing {
/*  18 */   private static CharSequence ¤¤name = "Precipitation";
/*  19 */   private static CharSequence ¤¤desc = "How often it has rained. Lack of downfall will decline Precipitation. Values below 25% will cause a drought that can be detrimental to growth.";
/*     */   
/*  21 */   private static CharSequence ¤¤drought = "¤Drought";
/*  22 */   private static CharSequence ¤¤droughtD = "¤Lack of rain has caused a drought. Our irrigation is working, but it's not enough. All our rooms dependent on water will be affected";
/*  23 */   private static final INFO binfo = new INFO(¤¤drought, ¤¤droughtD);
/*  24 */   private static CharSequence ¤¤mTitle = "¤Drought!";
/*  25 */   private static CharSequence ¤¤mBody = "¤The gods have forsaken {0}, and the rains have stopped. If this keeps up, it will devastate our crops! Everyone must now pray.";
/*     */   
/*  27 */   private static double rainspeed = 2.0D / TIME.secondsPerHour();
/*  28 */   private static double dry = 1.0D / (8 * TIME.secondsPerDay());
/*  29 */   private double lastSnow = 0.0D;
/*     */   
/*     */   private double sendTimer;
/*     */   
/*     */   static {
/*  34 */     D.ts(WeatherMoisture.class);
/*     */   }
/*     */ 
/*     */   
/*     */   WeatherMoisture() {
/*  39 */     super(¤¤name, ¤¤desc);
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  44 */     double d = getD();
/*  45 */     if (!(SETT.WEATHER()).snow.rainIsSnow()) {
/*  46 */       d += ds * rainspeed * (SETT.WEATHER()).rain.getD();
/*     */     }
/*     */     
/*  49 */     double snow = (SETT.WEATHER()).snow.getD();
/*  50 */     double thawed = this.lastSnow - snow;
/*  51 */     this.lastSnow = snow;
/*     */     
/*  53 */     if (thawed > 0.0D)
/*  54 */       d += thawed; 
/*  55 */     this.lastSnow = (SETT.WEATHER()).snow.getD();
/*     */ 
/*     */     
/*  58 */     if ((SETT.WEATHER()).temp.heat() > 0.0D) {
/*  59 */       d -= dry * ds;
/*     */     }
/*  61 */     this.sendTimer -= ds;
/*     */ 
/*     */     
/*  64 */     setD(d);
/*     */   }
/*     */ 
/*     */   
/*     */   public static RoomBoost makeBoost() {
/*  69 */     return new RoomBoost()
/*     */       {
/*     */         public INFO info()
/*     */         {
/*  73 */           return WeatherMoisture.binfo;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(RoomInstance r) {
/*  78 */           return CLAMP.d((SETT.WEATHER()).moisture.growthValue(), 0.0D, 1.0D);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DOUBLE.DOUBLE_MUTABLE setD(double d) {
/*  86 */     if (d < 0.25D && getD() >= 0.25D && 
/*  87 */       this.sendTimer < 0.0D && !VIEW.b().isActive()) {
/*  88 */       Str.TMP.clear().add(¤¤mBody).insert(0, (CharSequence)(FACTIONS.player()).name);
/*  89 */       (new MessageText(¤¤mTitle)).paragraph((CharSequence)Str.TMP).send();
/*  90 */       this.sendTimer = 10.0D;
/*     */     } 
/*     */     
/*  93 */     return super.setD(d);
/*     */   }
/*     */   
/*     */   public double growthValue() {
/*  97 */     return CLAMP.d(getD() * 4.0D, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init() {
/* 102 */     setD(0.75D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherMoisture.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */