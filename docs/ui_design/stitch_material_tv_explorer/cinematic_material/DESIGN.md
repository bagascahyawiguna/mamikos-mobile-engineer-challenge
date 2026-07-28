---
name: Cinematic Material
colors:
  surface: '#f9f9ff'
  surface-dim: '#d9dadf'
  surface-bright: '#f9f9ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f3f3f9'
  surface-container: '#ededf3'
  surface-container-high: '#e7e8ee'
  surface-container-highest: '#e2e2e8'
  on-surface: '#191c20'
  on-surface-variant: '#41474D'
  inverse-surface: '#2e3035'
  inverse-on-surface: '#f0f0f6'
  outline: '#707880'
  outline-variant: '#c0c7d0'
  surface-tint: '#006495'
  primary: '#004b71'
  on-primary: '#ffffff'
  primary-container: '#006495'
  on-primary-container: '#b7ddff'
  inverse-primary: '#8fcdff'
  secondary: '#50606e'
  on-secondary: '#ffffff'
  secondary-container: '#d1e2f2'
  on-secondary-container: '#546473'
  tertiary: '#4e4162'
  on-tertiary: '#ffffff'
  tertiary-container: '#66587b'
  on-tertiary-container: '#e3d1fa'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#cbe6ff'
  primary-fixed-dim: '#8fcdff'
  on-primary-fixed: '#001e30'
  on-primary-fixed-variant: '#004b71'
  secondary-fixed: '#d4e4f5'
  secondary-fixed-dim: '#b8c8d9'
  on-secondary-fixed: '#0d1d29'
  on-secondary-fixed-variant: '#394956'
  tertiary-fixed: '#ecdcff'
  tertiary-fixed-dim: '#d1bfe8'
  on-tertiary-fixed: '#211534'
  on-tertiary-fixed-variant: '#4e4162'
  background: '#f9f9ff'
  on-background: '#191c20'
  surface-variant: '#DEE3EB'
  rating-gold: '#FFB800'
typography:
  headline-lg:
    fontFamily: Manrope
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
    letterSpacing: -0.02em
  headline-lg-mobile:
    fontFamily: Manrope
    fontSize: 26px
    fontWeight: '700'
    lineHeight: 32px
  headline-sm:
    fontFamily: Manrope
    fontSize: 18px
    fontWeight: '600'
    lineHeight: 24px
  body-md:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  label-lg:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
    letterSpacing: 0.1px
  label-sm:
    fontFamily: Inter
    fontSize: 11px
    fontWeight: '500'
    lineHeight: 16px
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  margin-mobile: 16px
  margin-desktop: 32px
  gutter: 16px
  component-gap-xs: 4px
  component-gap-sm: 8px
  component-gap-md: 16px
---

## Brand & Style

The design system is a refined implementation of **Material Design 3**, optimized for a content-heavy media browser. The personality is professional, systematic, and "invisible"—meaning the UI recedes to let the vibrant TV show posters take center stage. 

The style utilizes a **Corporate / Modern** aesthetic with high-density information layouts. It emphasizes clarity through a content-first hierarchy, using generous whitespace and a strict adherence to the Material 3 tonal surface system. The emotional response should be one of reliability and ease of discovery, ensuring users feel the app is a premium portal to their favorite entertainment.

## Colors

The palette is rooted in a deep, cinematic blue-grey primary tone that feels authoritative yet neutral enough not to clash with diverse poster art.

- **Primary:** Used for key actions like the "Retry" button and active navigation states.
- **Surface & Neutral:** The system employs a "Neutral" background with subtle tonal shifts (Tonal Palettes) to differentiate between the list background and card surfaces.
- **Rating Gold:** A specific named color used exclusively for rating badges and stars to ensure high visibility against both light and dark poster backgrounds.
- **Dynamic Color (Concept):** While the base is static, the system is designed to support Android 12+ Color Extraction, where the primary and secondary tones can optionally adapt to the user's wallpaper.

## Typography

This design system pairs **Manrope** for headlines with **Inter** for functional text. This combination offers a modern, refined look (Manrope’s geometric flair) with maximum legibility in high-density data environments (Inter’s systematic clarity).

- **Headlines:** Use Manrope with tighter letter-spacing to create a "cinematic" title feel on the Detail Screen.
- **Body & Metadata:** Use Inter to handle the HTML summaries and metadata like premiere dates.
- **Scalability:** Large headlines transition to `-mobile` variants on small screens to prevent awkward line breaks in long TV show titles.

## Layout & Spacing

The system uses a **Fluid Grid** model with a base-8 rhythm (4dp, 8dp, 16dp, 24dp, 32dp). 

- **Mobile:** A single-column list for high detail or a 2-column grid for the browse screen. Margins are fixed at 16px.
- **Tablet/Desktop:** Content is centered with a max-width container (840dp) to prevent line lengths in summaries from becoming unreadable.
- **Rhythm:** Use `component-gap-sm` (8px) for internal card elements (title to rating) and `component-gap-md` (16px) for external spacing between cards.

## Elevation & Depth

In alignment with Material 3, this system prioritizes **Tonal Layers** over heavy drop shadows. 

- **Level 0 (Background):** The lowest layer, using the neutral background color.
- **Level 1 (Cards):** Surfaces use a subtle tonal tint (Surface Variant) to appear slightly "above" the background. No shadow is required here; contrast is achieved through color shift.
- **Level 2 (Navigation/App Bars):** Subtle elevation (3-6% opacity black shadow) is applied only during scroll to indicate the bar is passing over content.
- **Interactive States:** Buttons and cards use a slight shadow increase on hover/press to provide tactile feedback.

## Shapes

The shape language is consistently **Rounded**, creating a friendly and contemporary feel that complements the soft corners of modern smartphone displays.

- **Show Cards:** Utilize `rounded-lg` (16px) to frame poster art.
- **Rating Badges:** Use a smaller radius or semi-pill shape to distinguish them as functional overlays.
- **Input/Buttons:** Standard 8px radius (`rounded-md`) provides a professional balance between sharp and bubbly.

## Components

### Show Card
The central component of the app. It should feature a 2:3 aspect ratio image container. Titles are placed directly below the image or in a semi-transparent scrim at the bottom. The container must have a clipped `rounded-lg` corner to ensure the poster art matches the card shape.

### Rating Badge
A compact overlay usually positioned in the top-right or bottom-right of the poster. It uses the `rating-gold` color for the icon and `label-sm` for the text. It should have a high-contrast background (either deep neutral or a blurred backdrop) to ensure legibility over any poster color.

### Retry Button
A Material 3 "Filled Button" style. It should use the `primary_color` with `label-lg` typography. Ensure the touch target is at least 48x48dp. In error states, this button should be paired with a neutral-toned icon and a clear headline explaining the failure.

### Lists & Headers
List items should have a minimum height of 72dp for single-line content. Section headers in the Detail Screen (e.g., "Summary", "Cast") should use `headline-sm` with a `component-gap-sm` margin-bottom to maintain clear grouping.