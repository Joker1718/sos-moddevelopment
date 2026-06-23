/*    */ package settlement.weather;
/*    */ 
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.data.DOUBLE;
/*    */ import util.data.INT;
/*    */ import util.gui.misc.GHeader;
/*    */ import util.gui.slider.GSliderInt;
/*    */ import view.interrupter.ISidePanel;
/*    */ import view.main.VIEW;
/*    */ import view.sett.IDebugPanelSett;
/*    */ 
/*    */ final class UIWeather extends ISidePanel {
/*    */   public UIWeather(SWEATHER w) {
/* 15 */     titleSet("weather");
/*    */     
/* 17 */     for (WeatherThing ww : w.all()) {
/* 18 */       add(ww);
/*    */     }
/*    */     
/* 21 */     IDebugPanelSett.add("weather", new ACTION()
/*    */         {
/*    */           public void exe()
/*    */           {
/* 25 */             (VIEW.s()).panels.add(UIWeather.this, true);
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   private void add(final WeatherThing t) {
/* 32 */     this.section.add((RENDEROBJ)new GHeader((t.info()).name), 0, this.section.body().y2() + 2);
/* 33 */     INT.INTE in = new INT.INTE()
/*    */       {
/*    */         public int min()
/*    */         {
/* 37 */           return 0;
/*    */         }
/*    */ 
/*    */         
/*    */         public int max() {
/* 42 */           return 100;
/*    */         }
/*    */ 
/*    */         
/*    */         public int get() {
/* 47 */           return (int)Math.round(t.getD() * 100.0D);
/*    */         }
/*    */ 
/*    */         
/*    */         public void set(int ti) {
/* 52 */           t.setD(ti / 100.0D);
/*    */         }
/*    */       };
/* 55 */     this.section.add((RENDEROBJ)new GSliderInt(in, 120, 16, false), 220, this.section.getLastY1());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\UIWeather.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */